package com.acsk.shop.service;

import com.acsk.shop.dto.UserProfile;
import com.acsk.shop.model.user.BmbUser;

public interface UserService {
    BmbUser getUser(Long id);
    BmbUser addUser(BmbUser bmbUser);
    UserProfile getUserProfile(Long userId);
    BmbUser findByEmail(String email);
    BmbUser findByConfirmationToken(String confirmationToken);
}
