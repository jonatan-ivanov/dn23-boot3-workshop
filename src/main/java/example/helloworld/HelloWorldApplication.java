package example.helloworld;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

@EnableAutoConfiguration
@ComponentScan
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication builder = new SpringApplicationBuilder(HelloWorldApplication.class)
				.initializers(new HelloInitializer()).build();
		builder.run(args);
	}

	static class HelloInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

		@Override
		public void initialize(GenericApplicationContext applicationContext) {
			BeanDefinitionRegistry registry = applicationContext;
			RootBeanDefinition beanDefinition = new RootBeanDefinition(HelloNameProvider.class);
			registry.registerBeanDefinition("helloNameProvider", beanDefinition);
		}

	}

}
