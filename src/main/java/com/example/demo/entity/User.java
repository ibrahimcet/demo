package com.example.demo.entity;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo.validator.ValidEmail;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

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
