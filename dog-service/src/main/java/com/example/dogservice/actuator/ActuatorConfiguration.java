package com.example.dogservice.actuator;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.ObservationFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ActuatorConfiguration {

	@Bean
	ObservationFilter orgFilter(@Value("${spring.application.org}") String org) {
		return context -> context.addLowCardinalityKeyValue(KeyValue.of("org", org));
	}

}
