package com.sim.kotlin.domain.product.service

import com.sim.kotlin.domain.product.domain.Product
import com.sim.kotlin.domain.product.domain.ProductRepository
import com.sim.kotlin.domain.product.service.dto.ProductCreateRequest
import com.sim.kotlin.domain.product.service.dto.ProductInfoResponse
import com.sim.kotlin.domain.product.service.dto.ProductSimpleInfoResponse
import com.sim.kotlin.domain.user.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class KotlinProductService(
    val productRepository: ProductRepository
) {

    fun getProductById(productId: Long): ProductInfoResponse {
        val product = findProduct(productRepository::findProduct, productId)
        return ProductInfoResponse.mapProductToProductInfoResponse(product)
    }

    fun getAllProduct(pageable: Pageable): Page<ProductSimpleInfoResponse> {
        val allProduct = productRepository.findAll(pageable)
        return allProduct.map {
            ProductSimpleInfoResponse.mapProductToProductSimpleInfoResponse(it)
        }
    }

    fun saveProduct(request: ProductCreateRequest, findUser: (String) -> User, username: String){
        val user = findUser(username)
        productRepository.save(Product(request.name,request.cost,request.quantity, user))
    }

    fun sellProduct(product: Product, amount: Long){
        product.sellProduct(amount)
        productRepository.saveAndFlush(product)
    }

    fun findProductById(productId: Long)
        = findProduct(productRepository::findProduct, productId)

    private fun <T> findProduct(findMethod: (T)->Product?, specificationData: T): Product {
        val product = findMethod(specificationData)
        return product ?: throw IllegalArgumentException("존재하지 않는 상품입니다.")
    }
//    fun <T> findProduct(findMethod: (T)->Product?, specificationData: T)
//        = findMethod(specificationData) ?: throw IllegalArgumentException("존재하지 않는 상품입니다.")

}