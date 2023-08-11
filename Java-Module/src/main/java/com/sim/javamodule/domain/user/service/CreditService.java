package com.sim.javamodule.domain.user.service;

import com.sim.javamodule.domain.user.domain.Credit;
import com.sim.javamodule.domain.user.domain.CreditRepository;
import com.sim.javamodule.domain.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Slf4j
@Service
@Transactional
public class CreditService {

    private final CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public void plusCredit(Credit credit, Long amount){
        if(amount<0) {
            throw new IllegalArgumentException("크레딧은 0보다 커야합니다.");
        }
        credit.plusCredit(amount);
    }

    public void minusCredit(Credit credit, Long amount){
        if(amount<0) {
            throw new IllegalArgumentException("크레딧은 0보다 커야합니다.");
        }
        if(credit.getCreditAmount() < amount){
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        credit.minusCredit(amount);
        creditRepository.saveAndFlush(credit);
    }

    public Credit findByUserId(Function<Long, User> findById, Long userId) {
        return creditRepository.findByUserId(userId)
            .orElseGet(() -> {
                final User user = findById.apply(userId);
                final Credit credit = new Credit(user);
                return creditRepository.save(credit);
            });
    }


}
