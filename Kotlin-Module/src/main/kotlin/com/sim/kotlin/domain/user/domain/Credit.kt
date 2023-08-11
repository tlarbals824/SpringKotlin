package com.sim.kotlin.domain.user.domain

import jakarta.persistence.*

@Entity
class Credit(
    var creditAmount: Long = 0L,
    @ManyToOne(fetch = FetchType.LAZY) var user: User,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    var id: Long? = null

    fun plusCredit(amount: Long){
        creditAmount+=amount
    }

    fun minusCredit(amount: Long){
        creditAmount-=amount
    }
}