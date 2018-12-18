package com.acsk.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acsk.shop.model.user.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long id);
    List<Review> findByShopId(Long id);
    List<Review> findByShopIdAndUserId(Long shopId, Long userId);
}
