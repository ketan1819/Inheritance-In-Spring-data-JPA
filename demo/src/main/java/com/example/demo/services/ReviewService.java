package com.example.demo.services;

import com.example.demo.models.Booking;
import com.example.demo.models.Driver;
import com.example.demo.models.Review;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.DriverRepository;
import com.example.demo.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Calendar.DATE;

@Service
public class ReviewService implements CommandLineRunner
{
    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository; // this is called as composition


    public ReviewService(ReviewRepository reviewRepository,
                         BookingRepository bookingRepository,
                         DriverRepository driverRepository) //constructor injection
    {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

//    @Override
    @Transactional
    public void run(String... args) throws Exception
    {
        System.out.println("*****************");
        Review r = Review.builder()
                .content("Amazing ride quality and great Experience")
                .rating(4)
                .build();   // this code creates the plane java object that we want to store in the database

        Booking b = Booking
                .builder()
                .startTime(new Date())
                .endTime(new Date())
                .review(r)// passing the review object to the booking object so they can mapped together with forign key
                .build();

//
////        System.out.println(r);
////        reviewRepository.save(r);// this code actully executes the sql query
//        bookingRepository.save(b);


//        for(Review review:reviews)
//        {
//            System.out.println(review.getContent());
//        }
//        reviewRepository.deleteById(2l);

//        Optional<Driver> driver = driverRepository.findById(1L);

//        if (driver.isPresent())
//        {
//            System.out.println(driver.get().getName());
//            List<Booking> bobj = driver.get().getBookings();
//
//            for(Booking bboj:bobj)
//            {
//                System.out.println(bboj.getId());
//
//            }
//            Long driverId = driver.get().getId();
//            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//

//            for(Booking booking: bookings)
////            {
////                System.out.println(booking.getBookingStatus());
////            }

        // solving n+1 problem here so now lets look ahead

        List<Long>driverIds = new ArrayList<>(Arrays.asList(1L,2L,3L,4L,5L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

        for(Driver driver:drivers)
        {
            List<Booking>bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));

        }


//
        }
//        Optional<Booking> Bobj = bookingRepository.findById(1L);





    }






