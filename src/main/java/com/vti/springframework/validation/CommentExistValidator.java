package com.vti.springframework.validation;

import com.vti.springframework.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentExistValidator
        implements ConstraintValidator<CommentIdExit, Long> {
    private CommentRepository commentRepository;
    @Override
    public boolean isValid(
            Long id, ConstraintValidatorContext context
    ) {
        return commentRepository.existsById(id);
    }
}
