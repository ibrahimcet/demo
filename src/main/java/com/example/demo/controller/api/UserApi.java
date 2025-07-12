package com.example.demo.controller.api;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.Car;
import io.swagger.annotations.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<UserResponse> addUser(@ApiParam(value = "Add new user", required = true)@RequestBody @Valid UserRequest userRequest, HttpServletRequest request, HttpServletResponse response
    ) throws Exception;

    @ApiOperation(value = "Get existing user car", nickname = "getUser", response = Car.class, tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/user/{id}",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    ResponseEntity<UserResponse> getUser(@ApiParam(value = "User id", required = true) @PathVariable String id) throws Exception;
}
