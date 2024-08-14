package com.vti.springframework.dto;

import com.vti.springframework.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto extends RepresentationModel<UserDto> {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private User.Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
