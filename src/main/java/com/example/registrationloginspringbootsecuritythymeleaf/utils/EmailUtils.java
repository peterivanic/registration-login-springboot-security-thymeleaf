package com.example.registrationloginspringbootsecuritythymeleaf.utils;

import com.example.registrationloginspringbootsecuritythymeleaf.exceptions.InvalidEmailException;
import com.example.registrationloginspringbootsecuritythymeleaf.exceptions.InvalidInputException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailUtils {
    public void validate(String email) {

        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            throw new InvalidEmailException();
        } catch (NullPointerException e) {
            throw new InvalidInputException();
        }
    }
}
