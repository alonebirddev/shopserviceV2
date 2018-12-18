package com.acsk.shop.dto;

import com.acsk.shop.model.user.BmbUser;
import com.acsk.shop.model.user.Rating;
import com.acsk.shop.model.user.Review;
import lombok.Data;

import java.util.List;

@Data
public class UserProfile {
    BmbUser bmbUser;
    List<Review> reviewList;
    List<Rating> ratingList;
}
