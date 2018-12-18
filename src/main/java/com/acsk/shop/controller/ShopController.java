package com.acsk.shop.controller;

import com.acsk.shop.dto.ShopProfile;
import com.acsk.shop.exception.ResourceNotFoundException;
import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.service.ShopService;
import com.acsk.shop.exception.ShopException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shop")
@Api(value="Shops", description="Operations pertaining to shop data from shop table.")
public class ShopController {

    private static final Logger LOGGER = LogManager.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "View a list of available shops", notes = "Retrieve all shops", tags = {
            ("Shop") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ResponseEntity<List<Shop>> getAllShop() throws Exception {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @ApiOperation(value = "Get shop by id", notes = "Retrieve shop details by Shop Id.", tags = {
            ("Shop") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    public ResponseEntity<Shop> getShop(@PathVariable("id") long id) throws ShopException, ResourceNotFoundException {
        return ResponseEntity.ok(shopService.getShop(id));
    }

    @ApiOperation(value = "Insert new shop", notes = "Add new shop details to system", tags = {
            ("Shop") })
    @RequestMapping(value = "/shop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) throws ShopException {
        return new ResponseEntity<Shop>(shopService.addShop(shop), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Filter shops by services and area", notes = "Retrieve shops based on services are area", tags = {
            ("Shop") })
    @RequestMapping(value = "/shop/filter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shop>> shopFilter(@RequestBody ShopFilter shopFilter) throws ShopException {
        return ResponseEntity.ok(shopService.getShopByFilter(shopFilter));
    }

    @ApiOperation(value = "Get shops by city using ZIP code", notes = "Retrieve shops by zip code i.e. city", tags = {
            ("Shop") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop/city/{zip}", method = RequestMethod.GET)
    public ResponseEntity<List<Shop>> getShopsByCity(@PathVariable("zip") String zip) throws ShopException {

        throw new ShopException("thrown exception");
        //return null;
    }

    @ApiOperation(value = "Get shop profile.", notes = "Get shop profile.", tags = {
            ("Shop") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop/profile/{shopId}", method = RequestMethod.GET)
    public ResponseEntity<ShopProfile> getShopProfile(@PathVariable("shopId") Long shopId) throws ShopException {
        return ResponseEntity.ok(shopService.getShopProfile(shopId));
    }
}
