package com.xxxjay123.app.demoshopifyjava.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxjay123.app.demoshopifyjava.entity.Order;
import com.xxxjay123.app.demoshopifyjava.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Optional<Order> getOrderById(Long orderId) {
    return orderRepository.findById(orderId);
  }

  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order updateOrder(Long orderId, Order updatedOrder) {
    if (orderRepository.existsById(orderId)) {
      updatedOrder.setOrderId(orderId);
      return orderRepository.save(updatedOrder);
    }
    return null; // Handle not found case
  }

  public void deleteOrder(Long orderId) {
    orderRepository.deleteById(orderId);
  }

}
