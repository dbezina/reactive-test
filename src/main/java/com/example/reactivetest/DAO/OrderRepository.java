package com.example.reactivetest.DAO;

import com.example.reactivetest.entity.TacoOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<TacoOrder, Long> {
}
