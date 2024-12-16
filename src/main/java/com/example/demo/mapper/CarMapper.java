package com.example.demo.mapper;

import com.example.demo.dto.CarDto;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );


    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);

    Car carRequestToCar(CarRequest carRequest);

    CarResponse carDtoToCarResponse(CarDto carDto);


}