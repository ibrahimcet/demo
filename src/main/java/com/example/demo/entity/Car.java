package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Document(collection = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
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
