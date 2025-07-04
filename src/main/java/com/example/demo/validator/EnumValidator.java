package com.example.demo.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<ValidEnum, Enum<?>> {
    private String fieldName;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            // Customize the message with the field name
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fieldName + " cannot be null!")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}