package com.vti.springframework.service;

import com.vti.springframework.dto.UserDto;
import com.vti.springframework.entity.User;
import com.vti.springframework.form.UserCreateForm;
import com.vti.springframework.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto create(UserCreateForm form) {
        var user = modelMapper.map(form, User.class);
        var encoderPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encoderPassword);
        var savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
