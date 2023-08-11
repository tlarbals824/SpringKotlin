package com.sim.kotlin.domain.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?

    fun existsByUsername(username: String) : Boolean

    fun findUserById(userId : Long) : User?
}