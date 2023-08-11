package com.sim.javamodule.domain.user.domain;

import jakarta.persistence.*;

@Entity
public class Credit {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    private Long creditAmount;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Credit() {
    }

    public Credit(User user) {
        this.creditAmount = 0L;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Long getCreditAmount() {
        return creditAmount;
    }

    public User getUser() {
        return user;
    }

    public void plusCredit(Long amount){
        if(amount<0) {
            throw new IllegalArgumentException("추가할 크래딧은 0보다 커야합니다.");
        }
        this.creditAmount+=amount;
    }

    public void minusCredit(Long amount){
        if(amount<0) {
            throw new IllegalArgumentException("추가할 크래딧은 0보다 커야합니다.");
        }
        this.creditAmount-=amount;
    }
}
