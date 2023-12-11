/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.service.ReviewJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz1.model.*;

@RestController
public class ReviewController {
    @Autowired
    private ReviewJpaService reviewJpaService;

    @GetMapping("/reviews/{reviewId}/product")
    public Product getProductOfReview(@PathVariable("reviewId") int reviewId) {
        return reviewJpaService.getProductOfReview(reviewId);
    }

    @GetMapping("/products/reviews")
    public ArrayList<Review> getProductReviews() {
        return reviewJpaService.getProductReviews();
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Review getProductReviewById(@PathVariable("revieId") int reviewId) {
        return reviewJpaService.getProductReviewById(reviewId);
    }

    @PostMapping("/products/reviews")
    public Review addProductReview(@RequestBody Review review) {
        return reviewJpaService.addProductReview(review);
    }

    @PutMapping("/product/reviews/{reviewId}")
    public Review updateProductReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return reviewJpaService.updateProductReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews")
    public void deleteProductReview(@PathVariable("reviewId") int reviewId) {
        reviewJpaService.deleteProductReview(reviewId);
    }

}