/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.model.*;
import java.util.*;

public interface ReviewRepository {
    Product getProductOfReview(int reviewId);

    ArrayList<Review> getProductReviews();

    Review getProductReviewById(int reviewId);

    Review addProductReview(Review review);

    Review updateProductReview(int reviewId, Review review);

    void deleteProductReview(int reviewId);

}