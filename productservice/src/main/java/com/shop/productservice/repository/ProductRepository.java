package com.shop.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.productservice.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
