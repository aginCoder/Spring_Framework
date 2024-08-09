package com.vti.springframework.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CommentExistValidator.class)      // kiểm tra xem có tồn tại hay không
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentIdExit {
    String message() default "Comment id does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
