package com.sim.kotlin.domain.order.service

import com.sim.kotlin.domain.order.domain.Order
import com.sim.kotlin.domain.order.domain.OrderRepository
import com.sim.kotlin.domain.product.domain.Product
import com.sim.kotlin.domain.user.domain.User
import org.springframework.data.jpa.domain.QAbstractAuditable
import org.springframework.stereotype.Service

@Service
class KotlinOrderService(
    val orderRepository: OrderRepository,
) {
    fun saveOrder(quantity: Long, user: User, product: Product){
        orderRepository.save(Order(quantity, user, product))
    }
}