package com.shop.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.orderservice.dto.CreateOrderRequest;
import com.shop.orderservice.entity.OrderEntity;
import com.shop.orderservice.service.OrderService;

@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }
    
    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Long id) {
        return orderService.getOrder(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/user/{userId}")
    public List<OrderEntity> getUserOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
}