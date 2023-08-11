package com.sim.javamodule.domain.user.service;

import com.sim.javamodule.domain.user.domain.User;
import com.sim.javamodule.domain.user.domain.UserRepository;
import com.sim.javamodule.domain.user.service.dto.UserCreateRequest;
import com.sim.javamodule.domain.user.service.dto.UserInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Function;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(final UserCreateRequest request){
        final User user = request.mapToUser();
        if(userRepository.existsByUsername(request.username())){
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }
        userRepository.save(user);
    }

    public UserInfoResponse getUserByUsername(final String username){
        final User user = findByUsername(username);
        return UserInfoResponse.mapUserToUserInfoResponse(user);
    }

    public User findByUsername(String username) {
        return findUser(username, userRepository::findByUsername);
    }

    public User findById(Long userId){
        return findUser(userId, userRepository::findById);
    }

    private <T> User findUser(T specificationData, Function<T, Optional<User>> findMethod){
        return findMethod.apply(specificationData)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }

}
