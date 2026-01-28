package com.example.demo.models;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Booking extends BaseModel
{

    @OneToOne(cascade = {CascadeType.ALL})
    private Review review; // we have defined the 1:1 Replationship between the booking and review


    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private long totalDistance;

    @ManyToOne
    //bookingd : driver
    private Driver driver;

    @ManyToOne
    private Passenger passenger;


}
