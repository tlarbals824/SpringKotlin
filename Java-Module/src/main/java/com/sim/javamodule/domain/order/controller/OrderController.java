package com.sim.javamodule.domain.order.controller;

import com.sim.javamodule.domain.order.handler.OrderHandler;
import com.sim.javamodule.domain.order.service.dto.OrderCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderHandler orderHandler;

    public OrderController(OrderHandler orderHandler) {
        this.orderHandler = orderHandler;
    }


    /**
     * 1. 주문 요청
     * 2. 가격, 수량 검증 후 완료 후 생성
     */
    @PostMapping
    public void orderProduct(@RequestBody OrderCreateRequest request){
        orderHandler.orderProduct(request);
    }
}
