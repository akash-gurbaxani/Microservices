package com.microservices.microservices_user.entities;

import java.util.ArrayList;
import java.util.List;

import com.microservices.microservices_user.payloads.rating;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

    @Transient
    private List<rating> ratings = new ArrayList<>();
     

}
