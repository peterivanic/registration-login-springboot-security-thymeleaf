package com.example.registrationloginspringbootsecuritythymeleaf.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserRequestDto extends RequestDto {
    public final String username;
    public final String email;
    public final String password;

    @JsonCreator
    public UserRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
