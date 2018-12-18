package com.acsk.shop.dto;

import com.acsk.shop.model.Shop;
import com.acsk.shop.model.user.Rating;
import com.acsk.shop.model.user.Review;
import lombok.Data;

import java.util.List;

@Data
public class ShopProfile {
    Shop shop;
    List<Review> reviewList;
    List<Rating> ratingList;
}
