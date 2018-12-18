package com.acsk.shop.config.oauth2;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {

	@Bean
	@PostConstruct
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }
}
