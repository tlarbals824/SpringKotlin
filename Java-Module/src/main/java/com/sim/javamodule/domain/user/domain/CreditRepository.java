package com.sim.javamodule.domain.user.domain;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface CreditRepository extends JpaRepository<Credit, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Optional<Credit> findByUserId(Long userId);
}
