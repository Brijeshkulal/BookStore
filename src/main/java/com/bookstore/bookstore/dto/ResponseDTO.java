package com.bookstore.bookstore.dto;


import lombok.Data;

public @Data class ResponseDTO {

	
	private String message;

	
	public ResponseDTO(String message) {
		this.message = message;

	}

	
	

	
}
