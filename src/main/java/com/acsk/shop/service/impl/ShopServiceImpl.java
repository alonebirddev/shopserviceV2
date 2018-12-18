package com.acsk.shop.service.impl;

import java.util.List;

import com.acsk.shop.repository.ShopRepository;
import com.acsk.shop.service.RatingService;
import com.acsk.shop.service.ReviewService;
import com.acsk.shop.service.ShopService;
import com.acsk.shop.dto.ShopProfile;
import com.acsk.shop.model.Services;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.exception.ShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsk.shop.model.Shop;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	ReviewService reviewService;

	@Autowired
	RatingService ratingService;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Shop> getAllShops() throws ShopException {
		return shopRepository.findAll();
	}

	@Override
	public Shop getShop(long id) throws ShopException {
		return shopRepository.findOne(id);
	}

	@Override
	public List<Shop> getShopByCity(String zip) throws ShopException {
		return null;
	}

	@Override
	public Shop addShop(Shop shop) throws ShopException {
		return shopRepository.save(shop);
		//entityManager.persist(shop);
		//return new Shop();
	}

	@Override
	public List<Shop> getShopByFilter(ShopFilter shopFilter) throws ShopException {
		return null;
	}

	@Override
	public List<Services> getShopsServiceByShopId(long id) throws ShopException {
		return null;
	}

	@Override
	public ShopProfile getShopProfile(Long shopId) {
		ShopProfile shopProfile = new ShopProfile();
		shopProfile.setShop(shopRepository.findOne(shopId));
		shopProfile.setRatingList(ratingService.getRatingByShopId(shopId));
		shopProfile.setReviewList(reviewService.getReviewByShopId(shopId));
		return shopProfile;
	}
}
