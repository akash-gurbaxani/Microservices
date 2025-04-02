package com.microservices.microservices_user.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.microservices_user.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

   

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setStatus("404");
    apiResponse.setMessage(ex.getMessage());
    return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

}  
@ExceptionHandler(Exception.class)  
ResponseEntity<ApiResponse> handleGenericException(Exception ex){
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setStatus("500");
    apiResponse.setMessage(ex.getMessage());
    return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

}




}
