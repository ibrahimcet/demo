package validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnum {
    String message() default "{fieldName} can not be null!";

    String fieldName() default "";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}