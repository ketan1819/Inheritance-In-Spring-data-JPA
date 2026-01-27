package com.example.demo.services;

import com.example.demo.models.Review;
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

    public ReviewService(ReviewRepository reviewRepository) //constructor injection
    {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("*****************");
        Review r = Review.builder()
                .content("Amazing ride quality and great Experience")
                .rating(4)
                .build();   // this code creates the plane java object that we want to store in the database

//        System.out.println(r);
        reviewRepository.save(r); // this code actully executes the sql query

        Review r2 = Review.builder()
                .content("Worse experience ever")
                .rating(1)
                .build();
        List<Review> reviews = reviewRepository.findAll();
        reviewRepository.save(r2);

        for(Review review:reviews)
        {
            System.out.println(review.getContent());
        }
        reviewRepository.deleteById(2l);

    }
}
