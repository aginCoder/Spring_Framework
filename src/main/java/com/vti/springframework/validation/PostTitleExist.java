package com.vti.springframework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PostTitleExistsValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostTitleExist {
    String message() default "Post id does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
