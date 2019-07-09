package com.example.got.service;

import com.example.got.entity.Review;

import java.util.List;

public interface ReviewsService {
     List<Review> getReviewsForBook(String bookId);
     void saveReview(String bookId,String content);
}
