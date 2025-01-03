package com.shop.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.userservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

