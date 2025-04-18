package com.microservices.microservices_user.payloads;

import lombok.Data;

@Data
public class rating {

    private String ratingId;
    private String feedback;
    private String rating;
    private String userId;
    private String hotelId;

    private Hotel hotel;

}
