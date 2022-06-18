package com.prashhanth.tdd.reactive;

import com.prashhanth.tdd.entity.Car;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

	public Mono<ServerResponse> hello(ServerRequest request) {
		Car car =new Car();
		car.setModel("Marconi");
		return (Mono<ServerResponse>) ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(car.getModel()));
	}
}