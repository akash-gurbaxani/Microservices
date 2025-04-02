package com.microservices.microservices_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.microservices_user.entities.User;

public interface UserRepo extends JpaRepository<User,String> {

}
