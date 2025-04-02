package com.microservices.microservices_user.payloads;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String about;

    
}
