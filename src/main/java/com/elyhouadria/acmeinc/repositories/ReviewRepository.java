package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    void deleteReviewById(Integer id);
    Optional<Review> findReviewById(Integer id);


/*	List<Review> getAllReviews();

	void deleteReview(int reviewId);

	void updateReview(Review review);

	int addReview(Review review);
	
	public User findUserById(int userId);
	
	public Product findProductById(int productId);*/

}
