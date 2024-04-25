package com.example.reactivetest.services;

import com.example.reactivetest.DAO.OrderRepository;
import com.example.reactivetest.DAO.TacoRepository;
import com.example.reactivetest.entity.Taco;
import com.example.reactivetest.entity.TacoOrder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TacoOrderService {
    private final TacoRepository tacoRepo;
    private final OrderRepository orderRepo;

    public Mono<TacoOrder> save(TacoOrder tacoOrder){
        return Mono.just(tacoOrder)
                .flatMap(order -> {
                    List<Taco> tacos = order.getTacoList();
                    order.setTacoList(new ArrayList<>());
                    return tacoRepo.saveAll(tacos)
                            .map(taco -> {
                                order.addTaco(taco);
                                return order;
                            }).last();
                })
                .flatMap(orderRepo::save);
    }

    public Mono<TacoOrder> findById(Long id){
        return  orderRepo
                .findById(id)
                .flatMap(tacoOrder -> {
                    return tacoRepo.findAllById(tacoOrder.getTacoIds())
                            .map(taco -> {
                                tacoOrder.addTaco(taco);
                                return tacoOrder;
                            }).last();
                });

    }
}
