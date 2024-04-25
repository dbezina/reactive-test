package com.example.reactivetest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Taco {
    @Id
    private Long id;

    private @NonNull String name;
    @Column("ingredient_ids")
    private Set<Long> ingredientIds = new HashSet<>();

    public void addIngredient(Ingredient ingredient){
        ingredientIds.add(ingredient.getId());
    }
}
