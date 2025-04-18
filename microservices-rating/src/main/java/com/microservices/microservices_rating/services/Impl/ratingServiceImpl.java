package com.microservices.microservices_rating.services.Impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.microservices_rating.entities.rating;
import com.microservices.microservices_rating.payloads.ratingDto;
import com.microservices.microservices_rating.repositories.ratingRepo;
import com.microservices.microservices_rating.services.ratingService;

@Service
public class ratingServiceImpl implements ratingService {

	@Autowired
	private ratingRepo ratingRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ratingDto createRating(ratingDto dto) {
		rating rating = this.modelMapper.map(dto, rating.class);
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		rating save = this.ratingRepo.save(rating);
		return this.modelMapper.map(save, ratingDto.class);
	}

	@Override
	public ratingDto getRatingById(String id) {
		rating rating = this.ratingRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Rating not found with id :" + id));
		return this.modelMapper.map(rating, ratingDto.class);
	}

	@Override
	public List<ratingDto> getAllRatings() {
		List<rating> ratings = this.ratingRepo.findAll();
		List<ratingDto> ratingDtos = ratings.stream().map(rating -> this.modelMapper.map(rating, ratingDto.class))
				.collect(Collectors.toList());
		return ratingDtos;
	}

	@Override
	public void deleteRating(String id) {
		rating rating = this.ratingRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Rating not found with id : " + id));
		this.ratingRepo.delete(rating);

	}

	@Override
	public ratingDto updateRating(String id, ratingDto dto) {
		rating rating = this.ratingRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Rating not found with id :" + id));
		rating.setRating(dto.getRating());
		rating.setFeedback(dto.getFeedback());

		rating saveRating = this.ratingRepo.save(rating);

		return this.modelMapper.map(saveRating, ratingDto.class);
	}

	@Override
	public List<ratingDto> getRatingsByUserId(String userId) {
		List<rating> ratingList = this.ratingRepo.findByUserId(userId)
				.orElseThrow(() -> new RuntimeException("Rating not found with user id :" + userId));
		List<ratingDto> ratingDtos = ratingList.stream().map(rating -> this.modelMapper.map(rating, ratingDto.class))
				.collect(Collectors.toList());
				return ratingDtos;
	}

	@Override
	public List<ratingDto> getRatingsByHotelId(String hotelId) {
	List<rating> ratings = this.ratingRepo.findByHotelId(hotelId)
		.orElseThrow(() -> new RuntimeException("Rating not found with hotel id :" + hotelId));	
	
	List<ratingDto> ratingDtos = ratings.stream().map(rating -> this.modelMapper.map(rating, ratingDto.class))
		.collect(Collectors.toList());
	return ratingDtos;
	}

}
