package com.example.reactivetest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Table("taco_order")
public class TacoOrder {
    @Id
    private Long id;

    private Long tacoId;
  //  private Long userId;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryCity;
    private String deliveryState;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private Set<Long> tacoIds = new LinkedHashSet<>();

    private List<Taco> tacoList = new ArrayList<>();

    public void addTaco(Taco taco){
        tacoList.add(taco);
    }

}
