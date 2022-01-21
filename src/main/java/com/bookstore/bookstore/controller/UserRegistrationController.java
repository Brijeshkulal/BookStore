package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.LoginDto;
import com.bookstore.bookstore.dto.ResetPassword;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.dto.UserRegistrationDTO;
import com.bookstore.bookstore.service.IUserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserRegistrationController {

	@Autowired(required = true)
	private IUserRegistrationService registrationService;


	@PostMapping("/createuser")
	public ResponseEntity<ResponseDTO> createUser(@RequestBody UserRegistrationDTO userDTO) {
		ResponseDTO userData = registrationService.createUser(userDTO);
		ResponseDTO resDTO = new ResponseDTO("Create User Details Sucessfully :");
		log.info(String.valueOf(resDTO));
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@PutMapping("/updateuser/{token}")
	public ResponseEntity<ResponseDTO> updateUser(@PathVariable String token,@PathVariable int userid, @RequestBody UserRegistrationDTO userDTO) {
		ResponseDTO respDTO = registrationService.updateUserById(token,userid, userDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/deleteuser/{token}/{userid}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable String token, @PathVariable int userid) {
		ResponseDTO respDTO = registrationService.deleteUserById(token, userid);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/loginuser")
	public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDto loginDto) {
		ResponseDTO respDTO = registrationService.loginUser(loginDto);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/forgotpassword/{email}")
	public ResponseEntity<ResponseDTO> forgotPassword(@PathVariable String email) {
		ResponseDTO respDTO = registrationService.forgotPassword(email);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}


	@GetMapping("/verifyemail/{token}")
	public Boolean verifyEmail(@PathVariable String token) {
		return registrationService.verify(token);
	}

	@GetMapping("/getuserid/{token}")
	public int getUserId(@PathVariable String token) {
		return registrationService.getUserId(token);
	}

	@PostMapping("/resetpassword/{token}")
	ResponseEntity<ResponseDTO> resetPassword(@RequestBody ResetPassword password, @PathVariable String token) {
		ResponseDTO respDTO = registrationService.resetPassword(password, token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
