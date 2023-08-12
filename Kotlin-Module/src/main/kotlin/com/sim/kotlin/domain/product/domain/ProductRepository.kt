package com.sim.kotlin.domain.product.domain

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query

interface ProductRepository: JpaRepository<Product, Long> {

    @Query("select p from Product p where p.id = :productId")
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    fun findProduct(productId: Long) : Product?
}