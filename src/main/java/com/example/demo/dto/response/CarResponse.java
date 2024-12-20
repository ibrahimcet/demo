package com.example.demo.dto.response;

import com.example.demo.dto.enums.BodyType;
import com.example.demo.dto.enums.FuelType;
import com.example.demo.dto.enums.GearBox;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import validator.ValidEnum;

@Data
public class CarResponse {

    private String id;

    @NotNull(message = "brand can not be null!")
    private String brand;

    @NotNull(message = "model can not be null!")
    private String model;

    @ValidEnum(fieldName = "gearBox")
    private GearBox gearBox;

    @ValidEnum(fieldName = "bodyType")
    private BodyType bodyType;

    @ValidEnum(fieldName = "fuelType")
    private FuelType fuelType;

    @NotNull(message = "power can not be null!")
    private int power;

    @NotNull(message = "year can not be null!")
    private int year;

    @NotNull(message = "kilometer can not be null!")
    private int kilometer;

    @NotNull(message = "price can not be null!")
    private int price;
}
