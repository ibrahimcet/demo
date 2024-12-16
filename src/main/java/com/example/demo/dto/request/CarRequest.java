package com.example.demo.dto.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CarRequest {

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
