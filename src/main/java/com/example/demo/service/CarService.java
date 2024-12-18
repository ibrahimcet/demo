package com.example.demo.service;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.request.CarRequest;

import java.util.List;
import java.util.Optional;

public interface CarService {


    CarDto addNewCar(CarRequest carRequest);

    List<CarDto> getAllCarList();

    void deleteCar(String id);

    Optional<CarDto> getCarById(String id);
}
