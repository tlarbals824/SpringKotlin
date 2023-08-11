package com.sim.kotlin.domain.user.handler

import com.sim.kotlin.domain.user.domain.Credit
import com.sim.kotlin.domain.user.domain.User
import com.sim.kotlin.domain.user.service.KotlinCreditService
import com.sim.kotlin.domain.user.service.KotlinUserService
import com.sim.kotlin.domain.user.service.dto.CreditInfoResponse
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class KotlinCreditHandler(
    val userService: KotlinUserService,
    val creditService: KotlinCreditService,
) {

    fun updateCredit(userId: Long, amount: Long){
        val credit = creditService.findByUserId(userService::findById, userId)
        creditService.plusCredit(credit, amount)
    }

    fun getCreditInfo(userId: Long): CreditInfoResponse {
        val credit = creditService.findByUserId(userService::findById, userId)
        return CreditInfoResponse(credit.id , credit.creditAmount)
    }

}