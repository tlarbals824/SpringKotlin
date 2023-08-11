package com.sim.javamodule.domain.user.service.dto;

import com.sim.javamodule.domain.user.domain.User;
import lombok.Getter;

@Getter
public record UserInfoResponse(Long id, String username, String password) {
    public static UserInfoResponse mapUserToUserInfoResponse(final User user){
        return new UserInfoResponse(user.getId(), user.getUsername(), user.getPassword());
    }
}
