package com.acsk.shop.service.impl;

import com.acsk.shop.repository.ReviewRepository;
import com.acsk.shop.service.ReviewService;
import com.acsk.shop.model.user.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public List<Review> getReviwByUserId(Long id) {
        return reviewRepository.findByUserId(id);
    }

    @Override
    public List<Review> getReviewByShopId(Long id) {
        return reviewRepository.findByShopId(id);
    }

    @Override
    public List<Review> getReviewByShopIdAndUserId(Long shopId, Long userId) {
        return reviewRepository.findByShopIdAndUserId(shopId, userId);
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
