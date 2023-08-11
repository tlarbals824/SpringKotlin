package com.sim.kotlin.domain.user.domain

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import java.util.Optional

interface CreditRepository:JpaRepository<Credit, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    fun findByUserId(userId: Long) : Credit?
}