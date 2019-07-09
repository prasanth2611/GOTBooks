package com.example.got.controller.api;
import com.example.got.entity.Review;
import com.example.got.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import com.example.got.utils.Constants;

import java.util.List;

@RestController
public class ReviewsController {
    @Autowired
    ReviewsService reviewsService;

    @RequestMapping(value = Constants.GET_OR_POST_REVIEWS_FOR_BOOK_SELF_URL, method = RequestMethod.GET)
    public List<Review> getReviewsForBook(@PathVariable String bookId) {
        return reviewsService.getReviewsForBook(bookId);
    }
    @RequestMapping(value = Constants.GET_OR_POST_REVIEWS_FOR_BOOK_SELF_URL, method = RequestMethod.POST)
    public void saveReviewsForBook(@PathVariable String bookId, @RequestBody String content) {
         reviewsService.saveReview(bookId,content);
    }

}
