package com.microservices.microservices_hotel.services;

import java.util.List;

import com.microservices.microservices_hotel.payloads.hotelDto;

public interface hotelService {

hotelDto create(hotelDto hotelDto);
hotelDto getHotelById(String hotel_id);
List<hotelDto> getAllHotels();
hotelDto updateHotel(String hotel_id, hotelDto hotelDto);
void deleteHotel(String hotel_id);
List<hotelDto> getHotelByName(String name);

}
