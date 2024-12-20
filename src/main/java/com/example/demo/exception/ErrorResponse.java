package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Setter
@Getter
public class ErrorResponse {

    String message;
    int errorCode;
    HttpStatus status;

    public ErrorResponse(String message, int errorCode, HttpStatus status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
    }

}
