package com.sim.javamodule.domain.user.service.dto;

import com.sim.javamodule.domain.user.domain.User;

public record UserCreateRequest(String username, String password) {
    public User mapToUser(){
        return new User(username, password);
    }
}
