package com.example.dao.repository;

import com.example.dao.entity.OrderEntity;
import com.example.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity>findByStatus(OrderStatus status);
}
