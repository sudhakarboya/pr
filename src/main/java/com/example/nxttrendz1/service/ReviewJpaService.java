/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxttrendz1.service;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class ReviewJpaService implements ReviewRepository {
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;
    @Autowired
    private ProductJpaRepository productJpaRepostory;

    @Override
    public ArrayList<Review> getProductReviews() {
        return (ArrayList<Review>) reviewJpaRepository.findAll();
    }

    @Override
    public Review getProductReviewById(int reviewId) {
        return reviewJpaRepository.findById(reviewId).get();
    }

    @Override
    public Review addProductReview(Review review) {

        int productId = review.getProduct().getProductId();
        try {
            Product product = productJpaRepostory.findById(productId).get();
            review.setProduct(product);
            return review;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Review updateProductReview(int reviewId, Review review) {
        try {
            Review existReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                existReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                existReview.setRating(review.getRating());
            }
            if (review.getProduct() != null) {
                int productId = review.getProduct().getProductId();
                Product product = productJpaRepostory.findById(productId).get();
                existReview.setProduct(product);
            }
            reviewJpaRepository.save(existReview);
            return existReview;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProductReview(int reviewId) {
        try {
            reviewJpaRepository.deleteById(reviewId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Product getProductOfReview(int reviewId) {
        Review review = reviewJpaRepository.findById(reviewId).get();
        return review.getProduct();
    }

}