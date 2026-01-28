package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel
{
    private String name;


    @OneToMany(mappedBy = "passenger") // "passenger" is one of property in the booking class
    private List<Booking> bookings = new ArrayList<>();

}
