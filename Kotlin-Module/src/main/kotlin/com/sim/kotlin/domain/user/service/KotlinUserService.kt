package com.sim.kotlin.domain.user.service

import com.sim.kotlin.domain.user.domain.User
import com.sim.kotlin.domain.user.domain.UserRepository
import com.sim.kotlin.domain.user.service.dto.UserCreateRequest
import com.sim.kotlin.domain.user.service.dto.UserInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class KotlinUserService(
    val userRepository: UserRepository,
) {
    fun saveUser(request: UserCreateRequest) {
        val user = request.mapToUser()
        if (userRepository.existsByUsername(request.username))
            throw IllegalArgumentException("이미 존재하는 사용자입니다.");
        userRepository.save(user)
    }

    fun getUserByUsername(username: String): UserInfoResponse {
        val user = findByUsername(username)
        return UserInfoResponse.mapUserToUserInfoResponse(user)
    }

    fun findByUsername(username : String) = findUser(userRepository::findByUsername, username)

    fun findById(userId : Long) : User = findUser(userRepository::findUserById, userId)

    private fun <T> findUser(
        findMethod: (T) -> User?,
        specificationData: T,
    ) = findMethod(specificationData) ?: throw IllegalArgumentException("존재하지 않는 사용자입니다.")

}