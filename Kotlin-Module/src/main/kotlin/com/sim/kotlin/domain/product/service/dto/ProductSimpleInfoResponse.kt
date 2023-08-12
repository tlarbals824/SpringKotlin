package com.sim.kotlin.domain.product.service.dto

import com.sim.kotlin.domain.product.domain.Product

data class ProductSimpleInfoResponse(
    val productId: Long?,
    val name: String,
    val cost: Long,
) {
    companion object{
        fun mapProductToProductSimpleInfoResponse(product: Product) : ProductSimpleInfoResponse{
            return ProductSimpleInfoResponse(product.id, product.name, product.cost)
        }
    }
}