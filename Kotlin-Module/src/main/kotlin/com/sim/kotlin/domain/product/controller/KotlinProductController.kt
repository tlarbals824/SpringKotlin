package com.sim.kotlin.domain.product.controller

import com.sim.kotlin.domain.product.handler.KotlinProductHandler
import com.sim.kotlin.domain.product.service.KotlinProductService
import com.sim.kotlin.domain.product.service.dto.ProductCreateRequest
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class KotlinProductController(
    val productService: KotlinProductService,
    val productHandler: KotlinProductHandler,
) {
    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long) = productService.getProductById(productId)

    @GetMapping
    fun getAllProduct(@RequestParam size: Int, @RequestParam page: Int) = productService.getAllProduct(PageRequest.of(page, size))

    @PostMapping
    fun createProduct(@RequestBody reqest: ProductCreateRequest)
        = productHandler.createProduct(reqest)
}