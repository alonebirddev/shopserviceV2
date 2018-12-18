package com.acsk.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acsk.shop.model.user.BmbUser;

@Repository
public interface UserRepository extends JpaRepository<BmbUser, Long> {
	BmbUser findByEmail(String email);
	BmbUser findByConfirmationToken(String confirmationToken);
}

