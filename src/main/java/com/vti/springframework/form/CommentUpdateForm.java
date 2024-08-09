package com.vti.springframework.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentUpdateForm {
    @NotBlank(message = "Comment title must not believe blank")
    @Length(max = 50, message = "Comment name has max 50 characters")
    private String name;

    @Email(message = "Comment email in invalid")
    @NotBlank(message = "Comment description must not believe blank")
    @Length(max = 75, message = "Comment email has max 100 characters")
    private String email;

    @NotBlank(message = "Comment content must not believe blank")
    @Length(max = 100, message = "Comment body has max 150 characters")
    private String body;
}