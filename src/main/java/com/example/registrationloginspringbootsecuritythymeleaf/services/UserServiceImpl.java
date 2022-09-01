package com.example.registrationloginspringbootsecuritythymeleaf.services;

import com.example.registrationloginspringbootsecuritythymeleaf.dtos.UserRegistrationDto;
import com.example.registrationloginspringbootsecuritythymeleaf.models.Role;
import com.example.registrationloginspringbootsecuritythymeleaf.models.User;
import com.example.registrationloginspringbootsecuritythymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
