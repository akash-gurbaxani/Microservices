package com.microservices.microservices_hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices_hotel.payloads.hotelDto;
import com.microservices.microservices_hotel.services.hotelService;

@RestController
@RequestMapping("/api/hotel")
public class hotelController {

@Autowired    
private hotelService hotelService;

@PostMapping
public ResponseEntity<hotelDto> createHotel(@RequestBody hotelDto hotelDto) {
    hotelDto createHotel = this.hotelService.create(hotelDto);
    return ResponseEntity.ok(createHotel);

}

@GetMapping("/{hotel_id}")
public ResponseEntity<hotelDto> getHotelById(@PathVariable String hotel_id) {
    hotelDto hotel = this.hotelService.getHotelById(hotel_id);
    return ResponseEntity.ok(hotel);    
}

@GetMapping
public ResponseEntity<List<hotelDto>> getAllHotels() {
    List<hotelDto> hotels = this.hotelService.getAllHotels();
    return ResponseEntity.ok(hotels);
}

@GetMapping("/name/{hotelName}")
public ResponseEntity<List<hotelDto>> getHotelByName(@PathVariable String hotelName) {
    List<hotelDto> hotels = this.hotelService.getHotelByName(hotelName);
    return ResponseEntity.ok(hotels);

}
@DeleteMapping("/{hotel_id}")
public ResponseEntity<?> deleteHotel(@PathVariable String hotel_id) {
    this.hotelService.deleteHotel(hotel_id);
    return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);

}

@PutMapping("/{hotel_id}")
public ResponseEntity<hotelDto> updateHotel(@PathVariable String hotel_id, @RequestBody hotelDto hotelDto) {
    hotelDto updatedHotel = this.hotelService.updateHotel(hotel_id, hotelDto);
    return ResponseEntity.ok(updatedHotel);

}

}
