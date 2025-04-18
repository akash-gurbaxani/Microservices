package com.microservices.microservices_user.services.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.microservices_user.entities.User;
import com.microservices.microservices_user.exceptions.ResourceNotFoundException;
import com.microservices.microservices_user.payloads.Hotel;
import com.microservices.microservices_user.payloads.UserDto;
import com.microservices.microservices_user.payloads.rating;
import com.microservices.microservices_user.repositories.UserRepo;
import com.microservices.microservices_user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

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
        
        ////localhost:9093/api/rating/user/6147c95f-f74a-46e6-b1a3-ddfd70c6ea1e
        rating[] ratings = restTemplate.getForObject("http://localhost:9093/api/rating/user/"+id, rating[].class);
        
        List<rating> rating = Arrays.asList(ratings);
        rating.stream().map(r->{
            
            //localhost:9092/api/hotel/0613bd68-a7f8-44c5-8efa-8d6c0ef7fff
           Hotel hotel = restTemplate.getForObject("http://localhost:9092/api/hotel/"+r.getHotelId(), Hotel.class);
            r.setHotel(hotel);
            return r;

        }).collect(Collectors.toList());


        user.setRatings(rating);


        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
    List<User> users = this.userRepo.findAll(); 

    List<UserDto> userDtoList = new ArrayList<>();  
    for (User user : users) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
       
        rating[] ratings = this.restTemplate.getForObject("http://localhost:9093/api/rating/user/"+user.getId(), rating[].class);
        List<rating> rating = Arrays.asList(ratings);

        rating.stream().map(r->{
            
            //localhost:9092/api/hotel/0613bd68-a7f8-44c5-8efa-8d6c0ef7fff
           Hotel hotel = restTemplate.getForObject("http://localhost:9092/api/hotel/"+r.getHotelId(), Hotel.class);
            r.setHotel(hotel);
            return r;

        }).collect(Collectors.toList());

        userDto.setRatings(rating);
        userDtoList.add(userDto);

    }
    
    return userDtoList;

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
