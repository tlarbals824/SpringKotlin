package com.sim.kotlin.domain.order.domain

import com.sim.kotlin.domain.product.domain.Product
import com.sim.kotlin.domain.user.domain.User
import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(
    var orderQuantity: Long,
    @ManyToOne(fetch = FetchType.LAZY) var orderUser: User,
    @ManyToOne(fetch = FetchType.LAZY) var orderProduct: Product,
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null
}