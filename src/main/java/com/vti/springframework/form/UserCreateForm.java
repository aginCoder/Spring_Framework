package com.vti.springframework.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserCreateForm {
    @NotBlank(message = "User name must not believe blank")
    @Length(max = 50, message = "User name has max 50 characters")
    private String name;

    @NotBlank(message = "Username must not believe blank")
    @Length(max = 50, message = "Username has max 50 characters")
    private String username;

    @Email(message = "User email in invalid")
    @NotBlank(message = "User description must not believe blank")
    @Length(max = 50, message = "User email has max 50 characters")
    private String email;

    @NotBlank(message = "User password must not believe blank")
    @Length(
            min = 6, max = 16,
            message = "User password must between 6 and 16 characters")
    private String password;

    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER",
            message = "User role must be ADMIN, EMPLOYEE or MANAGER")
    private String role;
}
