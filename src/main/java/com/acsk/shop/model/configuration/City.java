package com.acsk.shop.model.configuration;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "shop_city")
public class City {
    @Id
    @Column(name = "city_id")
    Long id;
    String name;
    String description;
}
