package com.acsk.shop.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "bmb_shop")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    @ApiModelProperty(notes = "The database generated shop ID")
    Long id;
    String shopName;
    String shopAddress;
    Long shopArea;
    Long shopCity;
    String shopDescription;
    String shopLandMark;
    Long shopType;
    Long shopZip;
    Date foundingDate;
    String logo;

    @Column(name = "priceRangeMin", columnDefinition = "Decimal(10,2) default '0.0'")
    double priceRangeMin;

    @Column(name = "priceRangeMax", columnDefinition = "Decimal(10,2) default '0.0'")
    double priceRangeMax;

    @Column(name = "aggregateRating", columnDefinition = "Decimal(10,2) default '1.0'")
    private double aggregateRating;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop", cascade = { CascadeType.ALL })
    private Set<Services> shopServices;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop", cascade = { CascadeType.ALL })
    private Set<OpeningHours> shopOpeningHoursList;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shop")
    private GeoLocation geoLocation;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "shop")
    private ShopContact shopContact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Long getShopArea() {
        return shopArea;
    }

    public void setShopArea(Long shopArea) {
        this.shopArea = shopArea;
    }

    public Long getShopCity() {
        return shopCity;
    }

    public void setShopCity(Long shopCity) {
        this.shopCity = shopCity;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopLandMark() {
        return shopLandMark;
    }

    public void setShopLandMark(String shopLandMark) {
        this.shopLandMark = shopLandMark;
    }

    public Long getShopType() {
        return shopType;
    }

    public void setShopType(Long shopType) {
        this.shopType = shopType;
    }

    public Long getShopZip() {
        return shopZip;
    }

    public void setShopZip(Long shopZip) {
        this.shopZip = shopZip;
    }

    public double getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(double aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public Set<Services> getShopServices() {
        return shopServices;
    }

    public void setShopServices(Set<Services> shopServices) {
        this.shopServices = shopServices;
        if(!Objects.isNull(shopServices)) {
            for(Services services : this.shopServices) {
                services.setShop(this);
            }
        }
    }

    public Set<OpeningHours> getShopOpeningHoursList() {
        return shopOpeningHoursList;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(double priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public double getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(double priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public void setShopOpeningHoursList(Set<OpeningHours> shopOpeningHoursList) {
        this.shopOpeningHoursList = shopOpeningHoursList;
        if (!Objects.isNull(shopOpeningHoursList)) {
            for (OpeningHours openingHours : this.shopOpeningHoursList) {
                openingHours.setShop(this);
            }

        }
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
        if(!Objects.isNull(geoLocation)) {
            this.geoLocation.setShop(this);
        }
    }

    public ShopContact getShopContact() {
        return shopContact;
    }

    public void setShopContact(ShopContact shopContact) {
        this.shopContact = shopContact;
        if(!Objects.isNull(shopContact)) {
            this.shopContact.setShop(this);
        }
    }
}
