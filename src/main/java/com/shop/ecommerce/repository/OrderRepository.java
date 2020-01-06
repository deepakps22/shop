package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
