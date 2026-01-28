package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review
{
    @Column(nullable = false)
    private String passengerReviewContent;

//    @Column(nullable = false)
    private String passengerRating;

}
