package com.sim.kotlin.domain.order.domain

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository:JpaRepository<Order, Long> {
}