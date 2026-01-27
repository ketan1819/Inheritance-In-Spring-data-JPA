package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseModel
{
    @Id // this annotaion makes the id propeety a primary key of our table
    @GeneratedValue(strategy= GenerationType.TABLE)
    protected Long id;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt;


    @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about the format of the data object to be stored i..e date/time/timestamp
    @LastModifiedDate // this annotation tells spring that only handle it for object creation
    protected Date updatedAt;

}
