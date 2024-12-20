package com.example.demo.controller.api;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import io.swagger.annotations.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.processing.Generated;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Api(tags = "user",value = "the User API")
@RequestMapping("/api/v1")
public interface UserApi {

    @ApiOperation(value = "Add a user car", nickname = "addUser", response = Car.class, tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/user",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    ResponseEntity<User> addCar(@ApiParam(value = "Add new user", required = true)@RequestBody @Valid User body, HttpServletRequest request, HttpServletResponse response
    ) throws Exception;
}
