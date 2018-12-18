package com.acsk.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.acsk.shop.model")
public class MainApp{
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApp.class, args);
	}
}
