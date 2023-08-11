package com.sim.javamodule.domain.user.handler;

import com.sim.javamodule.domain.user.domain.Credit;
import com.sim.javamodule.domain.user.service.CreditService;
import com.sim.javamodule.domain.user.service.UserService;
import com.sim.javamodule.domain.user.service.dto.CreditInfoResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreditHandler {
    private final UserService userService;
    private final CreditService creditService;

    public CreditHandler(UserService userService, CreditService creditService) {
        this.userService = userService;
        this.creditService = creditService;
    }

    @Transactional
    public void updateCredit(Long userId, Long amount){
        final Credit credit = creditService.findByUserId(userService::findById, userId);
        creditService.plusCredit(credit, amount);
    }

    @Transactional
    public CreditInfoResponse getCreditInfo(Long userId){
        final Credit credit = creditService.findByUserId(userService::findById, userId);
        return new CreditInfoResponse(credit.getId(), credit.getCreditAmount());
    }
}