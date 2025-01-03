package com.shop.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shop.orderservice.dto.ProductDTO;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/product/{productId}")
    ProductDTO getProductById(@PathVariable("productId") Long productId);
}
