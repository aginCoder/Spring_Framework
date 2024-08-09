package com.vti.springframework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = PostExistsValidator.class)      // kiểm tra xem có tồn tại hay không
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostIdExist {
    String message() default "{post.id.Exists.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
