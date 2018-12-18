package com.acsk.shop.controller;

import com.acsk.shop.model.user.Review;
import com.acsk.shop.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/review")
@Api(value="Review", description="Operations pertaining to services reviews.")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @ApiOperation(value = "Get review by user Id.", notes = "Get review by user Id.", tags = {
            ("Review") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviwByUserId(@PathVariable("userId") Long userId) throws Exception {
        return ResponseEntity.ok(reviewService.getReviwByUserId(userId));
    }

    @ApiOperation(value = "Get review by shop Id.", notes = "Get review by shop Id.", tags = {
            ("Review") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review/shop/{shopId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewByShopId(@PathVariable("shopId") Long shopId) throws Exception {
        return ResponseEntity.ok(reviewService.getReviewByShopId(shopId));
    }

    @ApiOperation(value = "Get review by user Id and shop id.", notes = "Get review by user Id and shop id.", tags = {
            ("Review") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review/{shopId}/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getReviewByShopIdAndUserId(@PathVariable("userId") Long userId, @PathVariable("shopId") Long shopId) throws Exception {
        return ResponseEntity.ok(reviewService.getReviewByShopIdAndUserId(shopId,userId));
    }

    @ApiOperation(value = "Add Review.", notes = "Add Review.", tags = {
            ("Review") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ResponseEntity<Review> addReview(@RequestBody Review review) throws Exception {
        return ResponseEntity.ok(reviewService.addReview(review));
    }
}
