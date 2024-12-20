package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto addNewUser(UserRequest userRequest) {
          User user =  userRepository.save(UserMapper.INSTANCE.userRequestToUser(userRequest));
          return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public Optional<UserDto> getUserById(String id) {
        Optional<User> existingUser = userRepository.findById(id);
        return existingUser.map(UserMapper.INSTANCE::userToUserDto);
    }
}
