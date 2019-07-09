package com.example.got.service.impl;

import com.example.got.Repository.ReviewRepository;
import com.example.got.entity.Review;
import com.example.got.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewsServiceimpl implements ReviewsService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsForBook(String bookId) {
        return reviewRepository.findByBookId(bookId);
    }
    @Override
    public void saveReview(String bookId,String content){
        reviewRepository.save(new Review(bookId,content));
    }
}
