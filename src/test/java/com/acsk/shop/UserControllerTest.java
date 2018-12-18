package com.acsk.shop;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acsk.shop.controller.UserController;
import com.acsk.shop.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	String exampleUserJson = "{\r\n" + 
			"  \"activationKey\": \"key\",\r\n" + 
			"  \"authorities\": [\r\n" + 
			"  ],\r\n" + 
			"  \"city\": \"Nanded\",\r\n" + 
			"  \"confirmationToken\": \"ConfirmTkn\",\r\n" + 
			"  \"email\": \"ca10@gmail.com\",\r\n" + 
			"  \"enabled\": true,\r\n" + 
			"  \"firstName\": \"Chandrakant\",\r\n" + 
			"  \"lastName\": \"Audhutwar\",\r\n" + 
			"  \"password\": \"Audhutwar@7\",\r\n" + 
			"  \"phone\": 1111099669,\r\n" + 
			"  \"resetPasswordKey\": \"okoko\",\r\n" + 
			"  \"userName\": \"ca12345\"\r\n" + 
			"}";
}