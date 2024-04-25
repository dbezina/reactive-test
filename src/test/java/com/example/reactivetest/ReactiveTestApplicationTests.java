package com.example.reactivetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactiveTestApplicationTests {

	@Test
	void contextLoads() {
		Flux<String> fluxFruit = Flux
				.just("Banana", "Apple", "Pear", "Apple")
				.distinct()
				.take(3L).map(s -> "next fruit " + s)
				.repeat()
		//		.distinct()
				.skip(1L)
				.take(2)
			//	.map(s -> "next fruit "+ s)
				//.buffer(2)

				;
		fluxFruit.subscribe(s-> System.out.println(s));

		StepVerifier.create(fluxFruit)
			//	.expectNext("next fruit Banana")
				.expectNext("next fruit Apple")
				.expectNext("next fruit Pear")
				.verifyComplete();
	}

}
