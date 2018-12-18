/*
package com.acsk.shop.model;

import com.acsk.shop.model.Services;
import com.acsk.shop.model.Shop;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="jpa_services_dto")
public class ServiceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serviceCode")
    private Long id;
    private String name;
    private String description;

    @JoinColumn(name = "serviceCode", nullable = false)
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serviceCode", cascade = { CascadeType.ALL })
    private Services service;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
*/
