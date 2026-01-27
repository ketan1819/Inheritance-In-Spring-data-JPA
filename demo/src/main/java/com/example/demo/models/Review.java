package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Review extends BaseModel
{

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private double rating;


    @Override
    public String toString()
    {
        return "Review: "+this.content+" "+this.rating+" "+this.createdAt;

    }


}
// new Review(content,rating)