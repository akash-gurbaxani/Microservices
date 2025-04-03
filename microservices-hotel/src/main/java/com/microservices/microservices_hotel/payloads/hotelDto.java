package com.microservices.microservices_hotel.payloads;

import lombok.Data;

@Data
public class hotelDto {

    private String hotelId;
    private String hotelName;
    private String hotelDescription;
    private String hotelLocation;
    private int hotelPrice;

}
