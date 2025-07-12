package com.example.demo.controller;

import com.example.demo.controller.api.UserApi;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController implements UserApi {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;

    @Override
    public ResponseEntity<UserResponse> addUser(@Valid UserRequest userRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserResponse userResponse = UserMapper.INSTANCE.userDtoToUserResponse(userService.addNewUser(userRequest));
        logger.info("Added user car:{}", userResponse.getUsername());
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getUser(String id) throws Exception {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<UserDto> existingUserDto = userService.getUserById(id);
        return existingUserDto.map(userDto ->
                        new ResponseEntity<>(UserMapper.INSTANCE.userDtoToUserResponse(userDto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
