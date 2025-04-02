package com.microservices.microservices_user.services;

import java.util.List;

import com.microservices.microservices_user.payloads.UserDto;

public interface UserService {

  UserDto createUser(UserDto userDto);

  UserDto getUser(String id);

  List<UserDto> getUsers();

  UserDto updateUser(String id, UserDto userDto);
    
  void deleteUser(String id); 

  
}
