package com.example.demo.util;

import com.example.demo.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarUtil {

    public boolean matchesFilter(Car car, String key, String value) {
        return switch (key) {
            case "brand" -> car.getBrand().equalsIgnoreCase(value);
            case "model" -> car.getModel().equalsIgnoreCase(value);
            case "year" -> String.valueOf(car.getYear()).equals(value);
            case "kilometer" -> String.valueOf(car.getKilometer()).equals(value);
            case "price" -> String.valueOf(car.getPrice()).equals(value);
            default -> false; // Should not happen due to validation
        };
    }
}
