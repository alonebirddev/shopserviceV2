package com.acsk.shop.repository.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acsk.shop.model.user.BmbUser;

@Repository
public interface Oauth2UserRepository extends JpaRepository<BmbUser, String> {

    @Query("SELECT u FROM BmbUser u WHERE LOWER(u.userName) = LOWER(:userName)")
    BmbUser findByUsernameCaseInsensitive(@Param("userName") String username);

    @Query
    BmbUser findByEmail(String email);

    @Query
    BmbUser findByEmailAndActivationKey(String email, String activationKey);

    @Query
    BmbUser findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}