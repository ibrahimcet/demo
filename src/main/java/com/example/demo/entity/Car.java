package com.example.demo.entity;

import com.example.demo.dto.enums.BodyType;
import com.example.demo.dto.enums.FuelType;
import com.example.demo.dto.enums.GearBox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import validator.ValidEnum;

import jakarta.validation.constraints.NotNull;


@Document(collection = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
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
