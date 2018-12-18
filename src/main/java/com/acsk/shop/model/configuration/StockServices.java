package com.acsk.shop.model.configuration;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shop_stock_services")
@Data
public class StockServices {
    @Id
    @Column(name = "serviceCode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceCode;
    private String name;
    private String description;
}
