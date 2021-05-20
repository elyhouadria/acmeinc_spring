package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.Review;
import com.elyhouadria.acmeinc.services.ReviewServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController{

    private final ReviewServices reviewServices;

    public ReviewController(ReviewServices reviewServices){this.reviewServices=reviewServices;}



    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewServices.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Review> findReviewById(@PathVariable("id") Integer id){
        Review review = reviewServices.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        review.setCreationDate(new Date());
        Review newReview = reviewServices.addReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Review> updateReview(@RequestBody Review review){
        Review updateReview = reviewServices.updateReview(review);
        return new ResponseEntity<>(updateReview, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") Integer id){
        reviewServices.deleteReviewById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
