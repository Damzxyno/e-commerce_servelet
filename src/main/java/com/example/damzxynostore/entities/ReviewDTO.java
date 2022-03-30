package com.example.damzxynostore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReviewDTO {
    private int reviewId;
    private int productId;
    private int customerId;
    private int rating;
    private String headline;
    private String comment;
    private Date reviewTime;
}
