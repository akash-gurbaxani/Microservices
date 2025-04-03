package com.microservices.microservices_hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.microservices_hotel.entities.hotel;

public interface hotelRepo extends JpaRepository<hotel, String> {

    List<hotel> findByHotelName(String hotelName);
} 
