package com.sim.kotlin.domain.user.controller

import com.sim.kotlin.domain.user.handler.KotlinCreditHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/credit")
class KotlinCreditController(
    val creditHandler: KotlinCreditHandler
) {

    @GetMapping("/{userId}")
    fun getCreditInfo(
        @PathVariable userId: Long
    ) = creditHandler.getCreditInfo(userId)

    @PutMapping("/{userId}")
    fun updateCreditAmount(
        @PathVariable userId: Long,
        @RequestParam amount: Long,
    ) = creditHandler.updateCredit(userId, amount)
}