package com.shop.ecommerce.entity;

import javax.persistence.Entity;

import com.shop.ecommerce.data.BaseEntity;

@Entity
public class Product extends BaseEntity {
    private String name;
    private String description;

    public Product() {
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
}
