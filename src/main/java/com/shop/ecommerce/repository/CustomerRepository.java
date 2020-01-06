package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
