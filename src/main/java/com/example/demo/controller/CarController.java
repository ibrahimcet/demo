package com.example.demo.controller;

import com.example.demo.controller.api.CarApi;
import com.example.demo.dto.CarDto;
import com.example.demo.dto.request.CarRequest;
import com.example.demo.dto.response.CarResponse;
import com.example.demo.mapper.CarMapper;
import com.example.demo.service.impl.CarServiceImpl;
import com.example.demo.util.CarUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CarController implements CarApi {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarServiceImpl carService;

    @Autowired
    CarUtil carUtil;

    @Override
    public ResponseEntity<CarResponse> addCar(CarRequest carRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CarResponse carResponse = CarMapper.INSTANCE.carDtoToCarResponse(carService.addNewCar(carRequest));
        logger.info("Added new car:{}", carResponse.getBrand() + " "+ carResponse.getModel());
        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> filterCarList(Map<String, String> filters) throws Exception {

        //TODO: use predicate - querydsl for filtering in the search bar

        Set<String> validKeys = Set.of("brand", "model", "year", "kilometer", "price");

        for (String key : filters.keySet()) {
            if (!validKeys.contains(key)) {
                return new ResponseEntity<>("Invalid filter key: " + key, HttpStatus.BAD_REQUEST);
            }
        }

        // predicate çevir sorguyu
        // docker keykloack
        // docker mongoyu taşı
        // kafka notification
        // redis cache ekle
        // elasticsearch ve whitelist kullan



        List<CarResponse> carResponseList = carService.getAllCarList()
                .stream()
                .filter(car -> filters.entrySet().stream()
                        .allMatch(entry -> carUtil.matchesFilter(CarMapper.INSTANCE.carDtoToCar(car), entry.getKey(), entry.getValue())))
                .map(CarMapper.INSTANCE::carDtoToCarResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(carResponseList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCar(String id) throws Exception {

        Optional<CarDto> existingCarDto = this.carService.getCarById(id);
        if(existingCarDto.isPresent()){
            carService.deleteCar(existingCarDto.get().getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<CarResponse> getCar(String id) throws Exception {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<CarDto> existingCarDto = carService.getCarById(id);
        return existingCarDto.map(carDto ->
                new ResponseEntity<>(CarMapper.INSTANCE.carDtoToCarResponse(carDto), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
