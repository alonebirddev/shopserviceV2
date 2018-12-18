package com.acsk.shop.model;

import lombok.Data;

import java.util.List;

@Data
public class ShopFilter {
    List<String> shopCity;
    List<String> shopArea;
    List<Long> shopServices;
}
