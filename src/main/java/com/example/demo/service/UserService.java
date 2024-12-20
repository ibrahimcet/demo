package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.request.UserRequest;

import java.util.Optional;

public interface UserService {

    UserDto addNewUser(UserRequest userRequest);

    Optional<UserDto> getUserById(String id);

}
