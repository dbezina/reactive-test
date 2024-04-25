package com.example.reactivetest.DAO;

import com.example.reactivetest.entity.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TacoRepository extends ReactiveCrudRepository<Taco,Long> {
}
