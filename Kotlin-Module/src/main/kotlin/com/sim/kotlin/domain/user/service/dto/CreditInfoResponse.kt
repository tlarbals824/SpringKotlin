package com.sim.kotlin.domain.user.service.dto

import com.sim.kotlin.domain.user.domain.Credit
import com.sim.kotlin.domain.user.domain.User

data class CreditInfoResponse(
    val creditId: Long?,
    val amount: Long,
)
