package com.acsk.shop.controller;

import com.acsk.shop.dto.UserProfile;
import com.acsk.shop.model.user.BmbUser;
import com.acsk.shop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(value="User", description="Operations pertaining to users.")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Get User by user id.", notes = "Get User by user id.", tags = {
            ("User") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<BmbUser> getUser(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @ApiOperation(value = "Add User.", notes = "Add User.", tags = {
            ("User") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<BmbUser> addUser(@RequestBody BmbUser bmbUser) throws Exception {
        return ResponseEntity.ok(userService.addUser(bmbUser));
    }

    @ApiOperation(value = "Get user profile.", notes = "Get user profile.", tags = {
            ("User") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user/profile/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
}
