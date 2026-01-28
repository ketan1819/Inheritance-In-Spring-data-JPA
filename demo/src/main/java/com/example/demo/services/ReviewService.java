package com.example.demo.services;

import com.example.demo.models.Booking;
import com.example.demo.models.Review;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.Calendar.DATE;

@Service
public class ReviewService implements CommandLineRunner
{
    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         BookingRepository bookingRepository ) //constructor injection
    {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
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


//        System.out.println(r);
//        reviewRepository.save(r);// this code actully executes the sql query
        bookingRepository.save(b);


//        for(Review review:reviews)
//        {
//            System.out.println(review.getContent());
//        }
//        reviewRepository.deleteById(2l);

    }
}
