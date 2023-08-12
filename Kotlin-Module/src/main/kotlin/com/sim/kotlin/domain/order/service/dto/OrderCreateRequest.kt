package com.sim.kotlin.domain.order.service.dto

data class OrderCreateRequest(
    val productId: Long,
    val quantity: Long,
) {
}