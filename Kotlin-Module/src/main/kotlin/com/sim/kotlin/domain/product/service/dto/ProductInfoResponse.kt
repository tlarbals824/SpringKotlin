package com.sim.kotlin.domain.product.service.dto

import com.sim.kotlin.domain.product.domain.Product

data class ProductInfoResponse(
    val name: String,
    val cost: Long,
    val quantity: Long,
) {
    companion object{
        fun mapProductToProductInfoResponse(product: Product) : ProductInfoResponse{
            return ProductInfoResponse(product.name, product.cost, product.quantity)
        }
//        fun mapProductToProductInfoResponse(product: Product)
//            = ProductInfoResponse(product.name, product.cost, product.quantity)

    }
}