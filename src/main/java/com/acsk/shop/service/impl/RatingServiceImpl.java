package com.acsk.shop.service.impl;

import com.acsk.shop.repository.RatingRepository;
import com.acsk.shop.service.RatingService;
import com.acsk.shop.model.user.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingByUserId(Long id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByShopId(Long id) {
        return ratingRepository.findByShopId(id);
    }

    @Override
    public List<Rating> getRatingByShopIdAndUserId(Long shopId, Long userId) {
        return ratingRepository.findByShopIdAndUserId(shopId,userId);
    }

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
