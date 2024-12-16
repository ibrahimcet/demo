package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;

import java.util.List;

public interface CarService {


    CarDto addNewCar(CarRequest carRequest);

    List<CarDto> getAllCarList();
}
