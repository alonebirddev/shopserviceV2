package com.acsk.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acsk.shop.dto.UserProfile;
import com.acsk.shop.model.user.BmbUser;
import com.acsk.shop.repository.UserRepository;
import com.acsk.shop.service.RatingService;
import com.acsk.shop.service.ReviewService;
import com.acsk.shop.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    ReviewService reviewService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public BmbUser getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public BmbUser addUser(BmbUser bmbUser) {
    	bmbUser.setPassword(passwordEncoder.encode(bmbUser.getPassword()));
        return userRepository.save(bmbUser);
    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        UserProfile userProfile = new UserProfile();
        userProfile.setBmbUser(userRepository.findOne(userId));
        userProfile.setReviewList(reviewService.getReviwByUserId(userId));
        userProfile.setRatingList(ratingService.getRatingByUserId(userId));
        return userProfile;
    }
    
    @Override
    public BmbUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public BmbUser findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }
}
