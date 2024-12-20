package com.example.demo.controller;

import com.example.demo.controller.api.UserApi;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<User> addCar(@Valid User body, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = userService.addNewUser(body);
        //logger.info("Added new car:{}", carResponse.getBrand() + " "+ carResponse.getModel());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
