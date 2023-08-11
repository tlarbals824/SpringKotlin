package com.sim.javamodule.domain.order.service;

import com.sim.javamodule.domain.order.domain.Order;
import com.sim.javamodule.domain.order.domain.OrderRepository;
import com.sim.javamodule.domain.order.service.dto.OrderCreateRequest;
import com.sim.javamodule.domain.product.domain.Product;
import com.sim.javamodule.domain.user.domain.Credit;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Function;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

}
