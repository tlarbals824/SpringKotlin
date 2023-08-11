package com.sim.kotlin.domain.user.controller

import com.sim.kotlin.domain.user.service.KotlinUserService
import com.sim.kotlin.domain.user.service.dto.UserCreateRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class KotlinUserController(
    val userService: KotlinUserService
) {
    @GetMapping
    fun getUserInfo(
        @RequestParam username : String,
    ) = userService.getUserByUsername(username)

    @PostMapping
    fun createUser(
        @RequestBody request : UserCreateRequest,
    ) = userService.saveUser(request)
}