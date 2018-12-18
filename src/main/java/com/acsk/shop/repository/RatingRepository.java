package com.acsk.shop.repository;

import com.acsk.shop.model.user.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long id);
    List<Rating> findByShopId(Long id);
    List<Rating> findByShopIdAndUserId(Long shopId, Long userId);
}
