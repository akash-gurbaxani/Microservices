package com.microservices.microservices_user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "microservices-user")
public class User {

    @Id
    private String id;
    private String name;
    private String about;
    private String email;
     

}
