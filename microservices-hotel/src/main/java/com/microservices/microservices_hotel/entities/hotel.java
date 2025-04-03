package com.microservices.microservices_hotel.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "micro-hotel")
public class hotel {

    @Id
    @Column(name = "hotel_id", unique = true, nullable = false)
    private String hotelId;
    private String hotelName;
    private String hotelDescription;
    private String hotelLocation;
    private int hotelPrice;


  

}
