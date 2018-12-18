package com.acsk.shop.controller;

import com.acsk.shop.model.user.Rating;
import com.acsk.shop.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rating")
@Api(value="Rating", description="Operations pertaining to services ratings.")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @ApiOperation(value = "Get rating by user Id.", notes = "Get rating by user Id.", tags = {
            ("Rating") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/rating/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @ApiOperation(value = "Get rating by shop Id.", notes = "Get rating by shop Id.", tags = {
            ("Rating") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/rating/shop/{shopId}", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> getRatingByShopId(@PathVariable("shopId") Long shopId) throws Exception {
        return ResponseEntity.ok(ratingService.getRatingByShopId(shopId));
    }

    @ApiOperation(value = "Get rating by user Id and shop id.", notes = "Get rating by user Id and shop id.", tags = {
            ("Rating") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/rating/{shopId}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> getRatingByShopIdAndUserId(@PathVariable("userId") Long userId, @PathVariable("shopId") Long shopId) throws Exception {
        return ResponseEntity.ok(ratingService.getRatingByShopIdAndUserId(shopId,userId));
    }

    @ApiOperation(value = "Add Rating.", notes = "Add Rating.", tags = {
            ("Rating") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public ResponseEntity<Rating> addReview(@RequestBody Rating rating) throws Exception {
        return ResponseEntity.ok(ratingService.addRating(rating));
    }

}
