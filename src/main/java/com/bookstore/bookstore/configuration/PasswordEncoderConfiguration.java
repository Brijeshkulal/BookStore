package com.bookstore.bookstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


<<<<<<< HEAD
=======

>>>>>>> 1d7da98607b0e72eda8c0a73ac5209819b9f2880
@Configuration
public class PasswordEncoderConfiguration {

/**
 * creates the object of BCryptPasswordEncoder
 */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
