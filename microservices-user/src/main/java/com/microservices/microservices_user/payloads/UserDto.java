package com.microservices.microservices_user.payloads;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String about;

    private List<rating> ratings = new ArrayList<>();
    
}
