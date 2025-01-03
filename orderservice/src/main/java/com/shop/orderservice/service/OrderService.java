package com.shop.orderservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.orderservice.client.ProductClient;
import com.shop.orderservice.dto.CreateOrderRequest;
import com.shop.orderservice.entity.OrderEntity;
import com.shop.orderservice.entity.OrderItemEntity;
import com.shop.orderservice.repository.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductClient productClient;
    
    @Transactional
    public OrderEntity createOrder(CreateOrderRequest request) {
        // Validate product availability
        for (CreateOrderRequest.OrderItemRequest item : request.getItems()) {
            if (!(productClient.getProductById(item.getProductId()).getStock() >= item.getQuantity())) {
                throw new RuntimeException("Product not available in requested quantity");
            }
        }
        
        OrderEntity order = new OrderEntity();
        order.setUserId(request.getUserId());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");
        
        List<OrderItemEntity> orderItems = new ArrayList<>();
        double totalAmount = 0.0;
        
        for (CreateOrderRequest.OrderItemRequest item : request.getItems()) {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        
        return orderRepository.save(order);
    }
    
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Optional<OrderEntity> getOrder(Long id) {
        return orderRepository.findById(id);
    }
    
    public List<OrderEntity> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}