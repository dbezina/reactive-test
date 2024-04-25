package com.example.reactivetest;
import  static  org.assertj.core.api.Assertions.assertThat;

import com.example.reactivetest.DAO.IngredientRepository;
import com.example.reactivetest.entity.Ingredient;
import com.example.reactivetest.entity.enums.FoodType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

@DataR2dbcTest
public class IngredientRepositoryTest {
    @Autowired
    IngredientRepository ingredientRepo;

    @BeforeEach
    public void  setup(){
        System.out.println("BeforeEach");
        Flux<Ingredient> deleteAndInsert = ingredientRepo.deleteAll()
                .thenMany(ingredientRepo.saveAll(
                        Flux.just(
                                new Ingredient("FLTO", "Flour Tortilla", FoodType.WRAP),
                                new Ingredient("GRBF", "Groung Beef", FoodType.PROTEIN),
                                new Ingredient("CHED", "Cheddar", FoodType.CHEESE)
                        )));

        StepVerifier.create(deleteAndInsert)
                .expectNextCount(3L)
                .verifyComplete();
    }

    @Test
    public void shouldSaveAndFetchIngredients(){
        StepVerifier.create(
               ingredientRepo.findAll())
                .recordWith(ArrayList::new)
                .thenConsumeWhile(ingredient -> true )
                .consumeRecordedWith(ingredients -> {
                            assertThat(ingredients).hasSize(3);
                            assertThat(ingredients).contains(
                                    new Ingredient("FLTO", "Flour Tortilla", FoodType.WRAP));
                            assertThat(ingredients).contains(
                                    new Ingredient("GRBF", "Groung Beef", FoodType.PROTEIN));
                            assertThat(ingredients).contains(
                                    new Ingredient("CHED", "Cheddar", FoodType.CHEESE));
                        }
                    ).verifyComplete();

      StepVerifier.create(ingredientRepo.findBySlug("FLTO"))
                .assertNext(ingredient -> {
                    ingredient.equals(new Ingredient("FLTO", "Flour Tortilla", FoodType.WRAP));
                });
    }
}
