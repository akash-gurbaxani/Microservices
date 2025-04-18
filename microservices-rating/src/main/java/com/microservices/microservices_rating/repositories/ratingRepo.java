package com.microservices.microservices_rating.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.microservices_rating.entities.rating;

public interface ratingRepo extends JpaRepository<rating, String> {


  
    //Custom query methods can be defined here if needed
    // For example, to find ratings by userId or hotelId, you can add:
     Optional<List<rating>> findByUserId(String userId);
     Optional<List<rating>> findByHotelId(String hotelId);

}
