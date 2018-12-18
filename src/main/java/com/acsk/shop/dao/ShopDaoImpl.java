/*
package com.acsk.shop.dao;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.acsk.shop.model.ShopFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acsk.shop.model.Shop;

@Transactional
@Repository
public class ShopDaoImpl implements ShopDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Shop> getAllShops() {
		String hql = "FROM Shop as s ORDER BY s.shopId";
		return (List<Shop>) entityManager.createQuery(hql).getResultList();
	}

	public Shop getShop(long id) {
		return entityManager.find(Shop.class, id);
	}

	@Override
	public List<Shop> getShopByCity(String zip) {
        */
/*Query q = entityManager.createNativeQuery("select * from bmb_shop where shop_zip = :shopZip");
        q.setParameter("shopZip", zip);
        return q.getResultList();*//*

        return entityManager.createQuery(
                "SELECT s FROM Shop s WHERE s.shopZip = :shopZip")
                .setParameter("shopZip", zip)
                .getResultList();
	}

	public void addShop(Shop shop) {
		entityManager.persist(shop);
	}

	@Override
	public List<Shop> getShopByFilter(ShopFilter shopFilter) {

        //List<String> areas = new ArrayList<String>(Arrays.asList(shopFilter.getShopArea()));
        List<Shop> shops;

	    Query q = entityManager.createNativeQuery("SELECT ssx.shop_id FROM bmb_shop_services_xref ssx where ssx.service_id in :servicesList");
        q.setParameter("servicesList", shopFilter.getShopServices());
	    List<BigInteger> shopIds = q.getResultList();

        String queryStr = "from Shop where shopArea in :areaList";
        TypedQuery<Shop> query = entityManager.createQuery(queryStr, Shop.class);
        query.setParameter("areaList", shopFilter.getShopArea());
        shops =  query.getResultList();

        Set<Long> ids = new HashSet<Long>();
        for (BigInteger id:shopIds) {
            ids.add(id.longValue());
        }

        List<Shop> listOutput = shops.stream().filter(u -> ids.contains(u.getShopId())).collect(Collectors.toList());
        return listOutput;
	}
}
*/
