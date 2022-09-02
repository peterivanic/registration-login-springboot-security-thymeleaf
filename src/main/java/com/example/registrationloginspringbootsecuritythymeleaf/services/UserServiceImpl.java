package com.example.registrationloginspringbootsecuritythymeleaf.services;

import com.example.registrationloginspringbootsecuritythymeleaf.dtos.UserRegistrationDto;
import com.example.registrationloginspringbootsecuritythymeleaf.exceptions.*;
import com.example.registrationloginspringbootsecuritythymeleaf.models.Role;
import com.example.registrationloginspringbootsecuritythymeleaf.models.User;
import com.example.registrationloginspringbootsecuritythymeleaf.repository.UserRepository;
import com.example.registrationloginspringbootsecuritythymeleaf.utils.EmailUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final EmailUtils emailUtils;

    public UserServiceImpl(UserRepository userRepository, EmailUtils emailUtils) {
        this.userRepository = userRepository;
        this.emailUtils = emailUtils;
    }


    public void validateRequest(UserRegistrationDto dto) {
        if (dto == null) {
            throw new EmptyRequestBodyException();
        }
        if (dto.getFirstName() == null || dto.getFirstName().isEmpty()) {
            throw new EmptyUsernameException();
        }
        if (dto.getLastName() == null || dto.getLastName().isEmpty()) {
            throw new EmptyUsernameException();
        }
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new EmptyPasswordException();
        }
        if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
            throw new EmptyEmailException();
        }

    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        validateRequest(userRegistrationDto);
        emailUtils.validate(userRegistrationDto.getEmail());
        validateStore(userRegistrationDto);

        User user = new User(
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    public void validateStore(UserRegistrationDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EmailExistsException();
        }
    }
}
