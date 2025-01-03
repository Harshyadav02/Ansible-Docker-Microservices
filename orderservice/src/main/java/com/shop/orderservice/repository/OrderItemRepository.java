package com.shop.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.orderservice.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
