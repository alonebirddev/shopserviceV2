package com.acsk.shop.model.user;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shop_rating_id")
    Long id;
    Long userId;
    Long shopId;
    int ratingValue;
}
