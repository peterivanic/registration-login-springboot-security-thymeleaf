package com.example.registrationloginspringbootsecuritythymeleaf.services;

import com.example.registrationloginspringbootsecuritythymeleaf.dtos.UserRegistrationDto;
import com.example.registrationloginspringbootsecuritythymeleaf.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        return null;
    }
}
