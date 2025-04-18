package com.microservices.microservices_rating.services;

import java.util.List;

import com.microservices.microservices_rating.payloads.ratingDto;

public interface ratingService {

	ratingDto createRating(ratingDto dto);

	ratingDto getRatingById(String id);

	List<ratingDto> getAllRatings();

	void deleteRating(String id);

	ratingDto updateRating(String id, ratingDto dto);
	
	List<ratingDto> getRatingsByUserId(String userId);

	List<ratingDto> getRatingsByHotelId(String hotelId);
    

}
