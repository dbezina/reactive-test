package com.example.reactivetest.entity;

import com.example.reactivetest.entity.enums.FoodType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.lang.reflect.Type;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Ingredient {
    @Id
    private Long id;

    private @NonNull String slug;

    private @NonNull String name;

    @Column("food_type")
    private @NonNull FoodType type;

   // private @NonNull Long TacoId;

}
