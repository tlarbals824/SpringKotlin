package com.sim.kotlin.domain.user.service.dto

import com.sim.kotlin.domain.user.domain.User
import java.awt.PageAttributes

data class UserCreateRequest(
    val username: String,
    val password: String,
) {
    fun mapToUser() = User(username, password)
}