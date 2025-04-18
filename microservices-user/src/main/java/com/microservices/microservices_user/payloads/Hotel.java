package com.microservices.microservices_user.payloads;

import lombok.Data;

@Data
public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelDescription;
    private String hotelLocation;
    private int hotelPrice;


}
