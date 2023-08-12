package com.sim.kotlin.domain.product.domain

import com.sim.kotlin.domain.user.domain.User
import jakarta.persistence.*

/**
 * Kotlin에서는 getter, setter가 기본제공이다
 * <br> 하지만 setter만 막고싶을때는 어떻게 해야하지??
 */
@Entity
class Product(
    var name: String,
    var cost: Long,
    var quantity: Long,
    @ManyToOne(fetch = FetchType.LAZY) var productUploader: User
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    val id: Long? = null

    fun sellProduct(amount: Long){
        if(quantity<=0)
            throw IllegalArgumentException("품절된 상품입니다.")
        if(quantity<amount)
            throw IllegalArgumentException("최대 ${quantity}개만큼 구매가능합니다.")
        quantity-=amount
    }
}