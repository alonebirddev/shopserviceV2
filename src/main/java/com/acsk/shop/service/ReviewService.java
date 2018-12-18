package com.acsk.shop.service;

import java.util.List;

import com.acsk.shop.model.user.Review;

public interface ReviewService {
    List<Review> getReviwByUserId(Long id);
    List<Review> getReviewByShopId(Long id);
    List<Review> getReviewByShopIdAndUserId(Long shopId, Long userId);
    Review addReview(Review review);
}
