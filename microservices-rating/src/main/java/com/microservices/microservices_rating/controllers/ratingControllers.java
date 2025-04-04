package com.microservices.microservices_rating.controllers;

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

import com.microservices.microservices_rating.payloads.ratingDto;
import com.microservices.microservices_rating.services.ratingService;

@RestController
@RequestMapping("/api/rating")
public class ratingControllers {

	@Autowired
	private ratingService ratingService;

	@PostMapping
	public ResponseEntity<ratingDto> createRating(@RequestBody ratingDto dto) {
		ratingDto ratingDto = this.ratingService.createRating(dto);
		return new ResponseEntity<ratingDto>(ratingDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ratingDto>> getAllRating() {
		List<ratingDto> allRatings = this.ratingService.getAllRatings();
		return new ResponseEntity<List<ratingDto>>(allRatings, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ratingDto> getRatingById(@PathVariable String id) {
		ratingDto ratingDto = this.ratingService.getRatingById(id);
		return new ResponseEntity<ratingDto>(ratingDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRating(@PathVariable String id) {
		this.ratingService.deleteRating(id);
		return new ResponseEntity<>("Rating deleted successfully!", HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ratingDto> updateRating(@PathVariable String id, @RequestBody ratingDto dto) {
		ratingDto ratingDto = this.ratingService.updateRating(id, dto);
		return new ResponseEntity<ratingDto>(ratingDto, HttpStatus.OK);

	}

}
