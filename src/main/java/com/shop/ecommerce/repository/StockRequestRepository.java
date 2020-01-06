package com.shop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecommerce.entity.StockRequest;

public interface StockRequestRepository extends JpaRepository<StockRequest, Long> {
}
