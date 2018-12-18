package com.acsk.shop.repository.oauth2;


import org.springframework.data.jpa.repository.JpaRepository;

import com.acsk.shop.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
