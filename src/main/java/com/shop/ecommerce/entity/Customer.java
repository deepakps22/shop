package com.shop.ecommerce.entity;

import javax.persistence.Entity;

import com.shop.ecommerce.data.BaseEntity;

@Entity
public class Customer extends BaseEntity {

    private String name;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
