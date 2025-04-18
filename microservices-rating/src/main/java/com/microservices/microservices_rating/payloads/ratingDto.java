package com.microservices.microservices_rating.payloads;

import lombok.Data;

@Data
public class ratingDto {

    private String ratingId;
    private String feedback;
    private String rating;
    private String userId;
    private String hotelId;

}
