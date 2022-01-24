package com.bookstore.bookstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor

public class LoginDto {

    public String emailId;
    public String password;
    public String token;

}
