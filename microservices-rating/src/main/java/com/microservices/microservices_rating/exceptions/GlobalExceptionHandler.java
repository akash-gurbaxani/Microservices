package com.microservices.microservices_rating.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.microservices_rating.payloads.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse> hanlerRuntimeException(RuntimeException ex) {
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setStatuscode("404");

		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}

}
