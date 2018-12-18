package com.acsk.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acsk.shop.model.configuration.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}