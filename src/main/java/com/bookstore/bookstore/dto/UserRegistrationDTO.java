package com.bookstore.bookstore.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO 
{
	private String fullName;
	private String emailId;
	private String password;
	private String mobileNo;

}
