package com.acsk.shop.model.configuration;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "shop_area")
public class Area {
    @Id
    @Column(name = "area_id")
    Long id;
    String areaName;
    Long zipCode;
}
