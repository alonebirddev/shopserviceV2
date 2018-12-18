package com.acsk.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.acsk.shop.model.Shop;
import com.acsk.shop.repository.ShopRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShopRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ShopRepository shopRepository;
 
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Shop shop = new Shop();
        entityManager.persist(shop);
        entityManager.flush();
     
/*        // when
        Shop found = shop.findByName(shop.getShopName());
     
        // then
        assertThat(found.getShopName())
          .isEqualTo(shop.getShopName());*/
    }
 
}