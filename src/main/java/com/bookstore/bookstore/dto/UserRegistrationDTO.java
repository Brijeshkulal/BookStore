package com.bookstore.bookstore.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserRegistrationDTO 
{

	@Autowired
	private PasswordEncoder passwordEncoder;

	private String fullName;
	private String emailId;
	private String password;
	private String mobileNo;

}
