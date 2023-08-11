package com.sim.kotlin.domain.user.service

import com.sim.kotlin.domain.user.domain.Credit
import com.sim.kotlin.domain.user.domain.CreditRepository
import com.sim.kotlin.domain.user.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.KFunction1

@Transactional
@Service
class KotlinCreditService(
    val creditRepository: CreditRepository,
) {

    fun plusCredit(credit: Credit, amount: Long) {
        if (amount < 0)
            throw IllegalArgumentException("크레딧은 0보다 커야합니다.")
        credit.plusCredit(amount)
    }

    fun minusCredit(credit: Credit, amount: Long) {
        if (amount < 0)
            throw IllegalArgumentException("크레딧은 0보다 커야합니다.")
        if (credit.creditAmount < amount)
            throw IllegalArgumentException("금액이 부족합니다.")
        credit.minusCredit(amount)
        creditRepository.saveAndFlush(credit)
    }

    fun findByUserId(findMethod: (Long) -> User, userId: Long): Credit {
        val findCredit = creditRepository.findByUserId(userId)
        return findCredit ?: createCredit(findMethod(userId))
    }

    private fun createCredit(user : User): Credit {
        return creditRepository.save(Credit(user = user))
    }
}