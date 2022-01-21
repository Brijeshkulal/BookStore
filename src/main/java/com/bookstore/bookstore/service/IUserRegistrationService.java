package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.LoginDto;
import com.bookstore.bookstore.dto.ResetPassword;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.dto.UserRegistrationDTO;

public interface IUserRegistrationService
{

	ResponseDTO createUser(UserRegistrationDTO userDTO);

	ResponseDTO updateUserById(String token, int userid, UserRegistrationDTO userDTO);
	
	ResponseDTO deleteUserById(String token, int userid);

	ResponseDTO loginUser(LoginDto loginDto);

	ResponseDTO forgotPassword(String email);

	Boolean verify(String token);

	ResponseDTO resetPassword(ResetPassword password, String token);

	int getUserId(String token);

}
