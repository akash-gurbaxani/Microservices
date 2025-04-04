package com.microservices.microservices_rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class rating {

    @Id
    private String ratingId;
    private String feedback;
    private String rating;


}
