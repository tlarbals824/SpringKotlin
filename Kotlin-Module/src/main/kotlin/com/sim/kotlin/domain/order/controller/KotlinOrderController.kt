package com.sim.kotlin.domain.order.controller

import com.sim.kotlin.domain.order.handler.KotlinOrderHandler
import com.sim.kotlin.domain.order.service.dto.OrderCreateRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class KotlinOrderController(
    val orderHandler: KotlinOrderHandler,
) {
    @PostMapping
    fun orderProduct(@RequestBody request: OrderCreateRequest)
        = orderHandler.orderProduct(request)
}