package com.eventexpo.EventExpo.repository;

import com.eventexpo.EventExpo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerId(Long userId);
}