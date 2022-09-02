package com.example.registrationloginspringbootsecuritythymeleaf.services;

import com.example.registrationloginspringbootsecuritythymeleaf.dtos.UserRegistrationDto;
import com.example.registrationloginspringbootsecuritythymeleaf.models.User;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
    void validateRequest(UserRegistrationDto userRegistrationDto);
    void validateStore(UserRegistrationDto userRegistrationDto);
}
