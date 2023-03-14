package com.example.dogclient.web;

import java.util.List;

import com.example.dogclient.api.Api;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Spring MVC controller for {@literal /owner}.
 */
@RestController
public class DogsController {
	private final Api api;

	public DogsController(Api api) {
		this.api = api;
	}

	@GetMapping("/owner/{name}/dogs")
	List<String> dog(@PathVariable String name) {
		return this.api.ownedDogs(name);
	}

	@ExceptionHandler
	ProblemDetail onApiError(WebClientResponseException ex) {
		ProblemDetail details = ProblemDetail.forStatus(ex.getStatusCode());
		details.setProperty("downstream", ex.getResponseBodyAs(ProblemDetail.class));
		return details;
	}

}
