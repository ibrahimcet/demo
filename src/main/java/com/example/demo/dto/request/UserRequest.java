package com.example.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import com.example.demo.validator.ValidEmail;

@Data
public class UserRequest {

    @NotNull
    private String username;

    @ValidEmail
    private String email;

    @NotNull
    private String name;

    private String surname;

    @NotNull
    @Size(min = 5, max = 15, message = "Password length must be between 5-15 characters")
    private String password;

    private String gsm;
}
