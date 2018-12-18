package com.acsk.shop.service;

import java.util.List;

import com.acsk.shop.dto.ShopProfile;
import com.acsk.shop.model.Services;
import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.exception.ShopException;

public interface ShopService {
	public List<Shop> getAllShops() throws ShopException;
	public Shop getShop(long id) throws ShopException;
	public List<Shop> getShopByCity(String zip) throws ShopException;
	public Shop addShop(Shop shop) throws ShopException;
	public List<Shop> getShopByFilter(ShopFilter shopFilter) throws ShopException;
	List<Services> getShopsServiceByShopId(long id) throws ShopException;
	ShopProfile getShopProfile(Long shopId);
}
