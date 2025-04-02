package com.microservices.microservices_user.services.Impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.microservices_user.entities.User;
import com.microservices.microservices_user.exceptions.ResourceNotFoundException;
import com.microservices.microservices_user.payloads.UserDto;
import com.microservices.microservices_user.repositories.UserRepo;
import com.microservices.microservices_user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
       
        User user = this.modelMapper.map(userDto, User.class);
        String randomID = UUID.randomUUID().toString();
        user.setId(randomID);
        User save = this.userRepo.save(user);
        return this.modelMapper.map(save, UserDto.class);
    }

    @Override
    public UserDto getUser(String id) {
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id = " + id));
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
    List<User> UserList = this.userRepo.findAll();   
    return UserList.stream().map(user -> this.modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {
    User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id = " + id));
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        User save = this.userRepo.save(user);
        return this.modelMapper.map(save, UserDto.class);

    }

    @Override
    public void deleteUser(String id) {
    User user = this.userRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundException("User not found with id = " + id));
        this.userRepo.delete(user);
}

}
