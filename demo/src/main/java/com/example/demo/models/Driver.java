package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel
{
    private String name;

    @Column(nullable = false,unique = true)
    private String LicenseNumber;

    // onetomany association that is
    // 1:n  Driver : reviews or Driver associates with the multiple bookings
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}
