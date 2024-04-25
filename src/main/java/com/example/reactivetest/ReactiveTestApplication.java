package com.example.reactivetest;

import com.example.reactivetest.entity.enums.FoodType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ReactiveTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveTestApplication.class, args);

	}

}
