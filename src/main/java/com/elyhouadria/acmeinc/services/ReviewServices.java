package com.elyhouadria.acmeinc.services;
import com.elyhouadria.acmeinc.entities.Review;
import com.elyhouadria.acmeinc.exceptions.ProductNotFoundException;
import com.elyhouadria.acmeinc.repositories.ProductRepository;
import com.elyhouadria.acmeinc.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServices {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServices(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review findReviewById(Integer id) {
        return reviewRepository.findReviewById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id: " + id + " was not found"));
    }

    public void deleteReviewById(Integer id) {
        reviewRepository.deleteReviewById(id);
    }

}
