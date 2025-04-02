package com.microservices.microservices_user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices_user.payloads.ApiResponse;
import com.microservices.microservices_user.payloads.UserDto;
import com.microservices.microservices_user.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

@Autowired
private UserService userService;


@PostMapping
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    UserDto user = this.userService.createUser(userDto);
    return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
}
 
@GetMapping("/{id}")
ResponseEntity<UserDto> getUser(@PathVariable String id) {
    UserDto user = this.userService.getUser(id);
    return new ResponseEntity<UserDto>(user, HttpStatus.OK);

}

@GetMapping
ResponseEntity<List<UserDto>> getAllUser(){
    List<UserDto> users = this.userService.getUsers();
    return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
}

@PutMapping("/{id}")
ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto userDto){
    UserDto updateUser = this.userService.updateUser(id, userDto);
    return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);

}

@DeleteMapping("/{id}")
ResponseEntity<ApiResponse> deleteUser(@PathVariable String id){
    this.userService.deleteUser(id);
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setStatus("200");   
    apiResponse.setMessage("User deleted successfully");
    return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

}
}