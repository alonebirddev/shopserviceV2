package com.acsk.shop.service;

import com.acsk.shop.model.user.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getRatingByUserId(Long id);
    List<Rating> getRatingByShopId(Long id);
    List<Rating> getRatingByShopIdAndUserId(Long shopId, Long userId);
    Rating addRating(Rating rating);
}
