package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.LoginDto;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.dto.UserRegistrationDTO;
import com.bookstore.bookstore.exception.UserRegistrationException;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import com.bookstore.bookstore.util.JMSUtil;
import com.bookstore.bookstore.util.TokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Optional;

@Service
public class UserRegistrationService implements IUserRegistrationService {
	
	@Autowired
	private UserRegistrationRepository userRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public ResponseDTO createUser(UserRegistrationDTO userDTO)
	{
		Optional<UserRegistrationModel> isUserPresent = userRepository.findByEmailId(userDTO.getEmailId());
		if(!isUserPresent.isPresent())
		{
			UserRegistrationModel createUser = modelmapper.map(userDTO, UserRegistrationModel.class);
			createUser.setRegisteredDate(LocalDate.now());

			userRepository.save(createUser);
			return new ResponseDTO("User Register Sucessfully");
		}
		else
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}

	@Override
	public ResponseDTO updateUserById(String token,int userid, UserRegistrationDTO userDTO) 
	{
		int userId = TokenUtil.decodeToken(token);
		Optional<UserRegistrationModel> isUserPresent = userRepository.findById(userId);
		if (!isUserPresent.isPresent()) 
		{
			isUserPresent.get().setFullName(userDTO.getFullName());

			isUserPresent.get().setEmailId(userDTO.getEmailId());
			isUserPresent.get().setPassword(userDTO.getPassword());
			isUserPresent.get().setUpdatedDate(LocalDate.now());
			
			userRepository.save(isUserPresent.get());
			return new ResponseDTO("User Updated Successfully");
		}
		else 
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}

	@Override
	public ResponseDTO deleteUserById(String token, int userid) {
		
		int userId = TokenUtil.decodeToken(token);
		Optional<UserRegistrationModel> isUserPresent = userRepository.findById(userId);
		if (isUserPresent.isPresent()) 
		{
			userRepository.delete(isUserPresent.get());
			return new ResponseDTO("User Deleted Successfully");
		} 
		else 
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}


	@Override
	public ResponseDTO loginUser(LoginDto loginDto)
	{
		Optional<UserRegistrationModel> isUserPresent = userRepository.findByEmailId(loginDto.emailId);

		if (isUserPresent.isPresent()) 
		{
			if (isUserPresent.get().getEmailId().equals(loginDto.emailId) && isUserPresent.get().getPassword().equals(loginDto.password))
			{
				String token = TokenUtil.createToken(isUserPresent.get().getId());
				return new ResponseDTO("Login is Sucessfully");
			}
			else 
			{
				throw new UserRegistrationException(400,"Please check Email Id or Password, Retry");
			}
		} 
		else 
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}

	@Override
	public ResponseDTO forgotPassword(String email) 
	{
		
		Optional<UserRegistrationModel> isUserPresent = userRepository.findByEmailId(email);
		if (isUserPresent.isPresent()) 
		{
			if (isUserPresent.get().getEmailId().equals(email)) 
			{
				String body = "http://localhost:8080/resetpassword/"+ TokenUtil.createToken(isUserPresent.get().getId());
				JMSUtil.sendEmail(isUserPresent.get().getEmailId(), "Reset Password", body);
				return new ResponseDTO("Password is reset");
			} 
			else 
			{
				throw new UserRegistrationException(400,"Email id is incorrect");
			}
		}
		else 
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}

	@Override
	public Boolean verify(String token) 
	{
		int userId = TokenUtil.decodeToken(token);
		Optional<UserRegistrationModel> isUserPresent = userRepository.findById(userId);
		if (isUserPresent != null)
		{
			return true;
			
		} 
		else 
		{
			return false;
		}
	}


	@Override
	public int getUserId(String token) 
	{
		int userId = TokenUtil.decodeToken(token);
		Optional<UserRegistrationModel> isUserPresent = userRepository.findById(userId);
		if(isUserPresent.isPresent())
		{
			return userId;
		}
		else
		{
			throw new UserRegistrationException(400,"User is already Register, Please Try with another Email Id");
		}
	}
}