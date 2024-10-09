package com.eventexpo.EventExpo.service;

import com.eventexpo.EventExpo.model.Order;
import com.eventexpo.EventExpo.repository.EventRepository;
import com.eventexpo.EventExpo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EventRepository eventRepository;

    public Order createOrder(Order order) {
        // Ensure that the Event exists before saving the order
        eventRepository.findById(order.getEvent().getId())
                .orElseThrow(() -> new RuntimeException("Event not found with id " + order.getEvent().getId()));

        // Save the order
        return orderRepository.save(order);
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByBuyerId(userId);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStripeId(orderDetails.getStripeId());
        order.setTotalAmount(orderDetails.getTotalAmount());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}