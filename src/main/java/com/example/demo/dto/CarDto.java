package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CarDto {

    private String id;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private int year;

    @NotNull
    private int kilometer;

    @NotNull
    private int price;
}
