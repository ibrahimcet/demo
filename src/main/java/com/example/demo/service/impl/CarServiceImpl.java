package com.example.demo.service.impl;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    CarRepository carRepository;

    @Override
    public CarDto addNewCar(CarRequest carRequest) {
        Car car = carRepository.save(CarMapper.INSTANCE.carRequestToCar(carRequest));
        return CarMapper.INSTANCE.carToCarDto(car);
    }

    @Override
    public List<CarDto> getAllCarList() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper.INSTANCE::carToCarDto)
                .toList();
    }
}
