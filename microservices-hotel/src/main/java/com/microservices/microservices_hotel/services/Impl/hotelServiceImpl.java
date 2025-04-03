package com.microservices.microservices_hotel.services.Impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.microservices.microservices_hotel.entities.hotel;
import com.microservices.microservices_hotel.payloads.hotelDto;
import com.microservices.microservices_hotel.repositories.hotelRepo;
import com.microservices.microservices_hotel.services.hotelService;

@Service
public class hotelServiceImpl implements hotelService{

    @Autowired
    private hotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public hotelDto create(hotelDto hotelDto) {
      
        hotel hotel = this.modelMapper.map(hotelDto, hotel.class);
        String id = UUID.randomUUID().toString();
        hotel.setHotelId(id);
        hotel saveHotel = this.hotelRepo.save(hotel);
        return this.modelMapper.map(saveHotel, hotelDto.class);
    }

    @Override
    public hotelDto getHotelById(String hotel_id) {
       hotel hotel = this.hotelRepo.findById(hotel_id).orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotel_id));
        return this.modelMapper.map(hotel, hotelDto.class);
    }

    @Override
    public List<hotelDto> getAllHotels() {
        List<hotel> hotels = this.hotelRepo.findAll();
        List<hotelDto> hotelDtos = hotels.stream()
                .map(hotel -> this.modelMapper.map(hotel, hotelDto.class))
                .toList();
        return hotelDtos;
    }

    @Override
    public hotelDto updateHotel(String hotel_id, hotelDto hotelDto) {
        hotel hotel = this.hotelRepo.findById(hotel_id).orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotel_id));
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setHotelDescription(hotelDto.getHotelDescription());
        hotel.setHotelLocation(hotelDto.getHotelLocation());
        hotel.setHotelPrice(hotelDto.getHotelPrice());
        hotel updatedHotel = this.hotelRepo.save(hotel);
        return this.modelMapper.map(updatedHotel, hotelDto.class);
    }

    @Override
    public void deleteHotel(String hotel_id) {
        hotel hotel = this.hotelRepo.findById(hotel_id).orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotel_id));
        this.hotelRepo.delete(hotel);
    }

    @Override
    public List<hotelDto> getHotelByName(String name) {
        List<hotel> hotels = this.hotelRepo.findByHotelName(name);
        if (hotels.isEmpty()) {
            throw new RuntimeException("No hotels found with name: " + name);
        }
    
        List<hotelDto> hotelDtos = hotels.stream()
                .map(hotel -> this.modelMapper.map(hotel, hotelDto.class))
                .toList();
        return hotelDtos;
    }

}
