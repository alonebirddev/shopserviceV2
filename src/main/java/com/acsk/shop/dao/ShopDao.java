package com.acsk.shop.dao;

import java.util.List;

import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;

public interface ShopDao {

	public List<Shop> getAllShops();
	public Shop getShop(long id);
	public List<Shop> getShopByCity(String zip);
	public void addShop(Shop shop);
	public List<Shop> getShopByFilter(ShopFilter shopFilter);
}
