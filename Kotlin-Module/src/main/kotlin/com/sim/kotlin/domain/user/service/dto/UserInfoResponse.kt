package com.sim.kotlin.domain.user.service.dto

import com.sim.kotlin.domain.user.domain.User

data class UserInfoResponse(
    val id: Long?,
    val username: String,
    val password: String,
){
    companion object{
        fun mapUserToUserInfoResponse(user: User)=UserInfoResponse(user.id, user.username, user.password)
    }
}