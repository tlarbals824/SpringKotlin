package com.sim.kotlin.domain.order.handler

import com.sim.kotlin.domain.order.service.KotlinOrderService
import com.sim.kotlin.domain.order.service.dto.OrderCreateRequest
import com.sim.kotlin.domain.product.service.KotlinProductService
import com.sim.kotlin.domain.user.service.KotlinCreditService
import com.sim.kotlin.domain.user.service.KotlinUserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class KotlinOrderHandler(
    val orderService: KotlinOrderService,
    val productService: KotlinProductService,
    val userService: KotlinUserService,
    val creditService: KotlinCreditService,
) {
    fun orderProduct(request: OrderCreateRequest){
        val credit = creditService.findByUserId(userService::findById, 1L)
        val product = productService.findProductById(1L)
        creditService.minusCredit(credit, request.quantity*product.cost)
        productService.sellProduct(product, request.quantity)
        orderService.saveOrder(request.quantity, credit.user, product)
    }
}