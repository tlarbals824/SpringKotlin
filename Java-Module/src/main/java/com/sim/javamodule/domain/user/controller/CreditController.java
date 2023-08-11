package com.sim.javamodule.domain.user.controller;

import com.sim.javamodule.domain.user.handler.CreditHandler;
import com.sim.javamodule.domain.user.service.dto.CreditInfoResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {
    private final CreditHandler creditHandler;

    public CreditController(CreditHandler creditHandler) {
        this.creditHandler = creditHandler;
    }

    @GetMapping("/{userId}")
    public CreditInfoResponse getCreditInfo(@PathVariable Long userId){
        return creditHandler.getCreditInfo(userId);
    }

    @PutMapping("/{userId}")
    public void updateCreditAmount(@PathVariable Long userId, @RequestParam Long amount){
        creditHandler.updateCredit(userId, amount);
    }
}
