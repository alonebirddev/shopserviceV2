package com.acsk.shop.controller;

import com.acsk.shop.model.configuration.Area;
import com.acsk.shop.model.configuration.City;
import com.acsk.shop.model.configuration.StockServices;
import com.acsk.shop.service.ConfigurationService;
import com.acsk.shop.exception.ShopException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/configuration")
@Api(value="Service", description="Operations pertaining to services data from service table.")
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    // Stock services

    @ApiOperation(value = "Get all stock services", notes = "Get all stock services", tags = {
            ("Stock Services") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/stockservice", method = RequestMethod.GET)
    public ResponseEntity<List<StockServices>> getAllStockServices() throws Exception {
        return ResponseEntity.ok(configurationService.getAllStockServices());
    }

    @ApiOperation(value = "Get service by id", notes = "Get service by id", tags = {
            ("Stock Services") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/stockservice/{id}", method = RequestMethod.GET)
    public ResponseEntity<StockServices> getStockServiceById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(configurationService.getStockServices(id));
    }

    @ApiOperation(value = "Insert new Stock Services", notes = "Insert new Stock Services", tags = {
            ("Stock Services") })
    @RequestMapping(value = "/stockservice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockServices> saveShop(@RequestBody StockServices stockServices) throws ShopException {
        return new ResponseEntity<StockServices>(configurationService.addStockService(stockServices), HttpStatus.CREATED);
    }

    // City

    @ApiOperation(value = "Get all cities", notes = "Get all cities", tags = {
            ("City") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getAllCities() throws Exception {
        return ResponseEntity.ok(configurationService.getAllCities());
    }

    @ApiOperation(value = "Get city by id", notes = "Get city by ids", tags = {
            ("City") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(configurationService.getCity(id));
    }

    @ApiOperation(value = "Insert new city", notes = "Insert new city", tags = {
            ("City") })
    @RequestMapping(value = "/city", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveShop(@RequestBody City city) throws ShopException {
        return new ResponseEntity<City>(configurationService.addNewCity(city), HttpStatus.CREATED);
    }

    // Area

    @ApiOperation(value = "Get all areas.", notes = "Get all areas.", tags = {
            ("Area") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/area", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> getAllAreas() throws Exception {
        return ResponseEntity.ok(configurationService.getAllAreas());
    }

    @ApiOperation(value = "Get area by id", notes = "Get area by ids", tags = {
            ("Area") })
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
    public ResponseEntity<Area> getAreaById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(configurationService.getAreaById(id));
    }

    @ApiOperation(value = "Insert new area", notes = "Insert new area", tags = {
            ("Area") })
    @RequestMapping(value = "/area", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> saveArea(@RequestBody Area area) throws ShopException {
        return new ResponseEntity<Area>(configurationService.saveArea(area), HttpStatus.CREATED);
    }
}
