package com.sim.kotlin.domain.product.handler

import com.sim.kotlin.domain.product.service.KotlinProductService
import com.sim.kotlin.domain.product.service.dto.ProductCreateRequest
import com.sim.kotlin.domain.user.service.KotlinUserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class KotlinProductHandler(
    val productService: KotlinProductService,
    val userService: KotlinUserService,
) {
    fun createProduct(reqest: ProductCreateRequest)
        = productService.saveProduct(reqest, userService::findByUsername, "test")
}