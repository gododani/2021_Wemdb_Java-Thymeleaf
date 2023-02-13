package com.example.film.model;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private Date createDate;
    private long userId;
    private long filmId;
    private int rating;

    public String getCreateDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(createDate);
    }
}
