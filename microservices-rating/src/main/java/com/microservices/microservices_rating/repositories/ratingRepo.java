package com.microservices.microservices_rating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.microservices_rating.entities.rating;

public interface ratingRepo extends JpaRepository<rating, String> {
  

}
