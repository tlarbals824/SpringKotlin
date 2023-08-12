package com.sim.kotlin.domain.product.service.dto

data class ProductCreateRequest(
    val name: String,
    val cost: Long,
    val quantity: Long,
) {
}