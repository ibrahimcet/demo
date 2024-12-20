package com.example.demo.controller.api;

import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.annotation.processing.Generated;
import java.util.Map;

@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen")
@Api(tags = "car",value = "the Car API")
@RequestMapping("/api/v1")
@Validated
public interface CarApi {

    @ApiOperation(value = "Add a new car", nickname = "addCar", response = Car.class, tags = {"car"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/car",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    ResponseEntity<CarResponse> addCar(@ApiParam(value = "Add new car", required = true)@RequestBody @Valid CarRequest body, HttpServletRequest request, HttpServletResponse response
    ) throws Exception;


    @ApiOperation(value = "Filter car list", nickname = "filteredCarsList", response = Car.class, tags = {"car"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/cars",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    ResponseEntity<?> filterCarList(@ApiParam(value = "Filter car list", required = true) @RequestParam Map<String, String> filters) throws Exception;


    @ApiOperation(value = "Delete existing car", nickname = "deleteCar", response = Car.class, tags = {"car"})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/car/{id}",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.DELETE)
    ResponseEntity<String> deleteCar(@ApiParam(value = "Car id", required = true) @PathVariable String id) throws Exception;

    @ApiOperation(value = "Get existing car", nickname = "getCar", response = Car.class, tags = {"car"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = Car.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/car/{id}",
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    ResponseEntity<CarResponse> getCar(@ApiParam(value = "Car id", required = true) @PathVariable String id) throws Exception;

}
