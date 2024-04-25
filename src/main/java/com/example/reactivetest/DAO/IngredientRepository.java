package com.example.reactivetest.DAO;

import com.example.reactivetest.entity.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient,Long> {
    Mono<Ingredient> findBySlug(String slug);
}
