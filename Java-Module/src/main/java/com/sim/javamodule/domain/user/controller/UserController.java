package com.sim.javamodule.domain.user.controller;

import com.sim.javamodule.domain.user.service.UserService;
import com.sim.javamodule.domain.user.service.dto.UserCreateRequest;
import com.sim.javamodule.domain.user.service.dto.UserInfoResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserInfoResponse getUserInfo(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

}
