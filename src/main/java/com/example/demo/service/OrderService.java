package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.orderRequest;
import com.example.demo.model.Order1;
import com.example.demo.model.OrderItem;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order1 createOrder(Order1 order) {
		return orderRepository.save(order);
	}

	public List<Order1> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order1 getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Order1 updateOrder(Long id, Order1 order) {
		Order1 existingOrder = orderRepository.findById(id).orElse(null);
		if (existingOrder == null) {
			return null;
		}
		existingOrder.setOrderNumber(order.getOrderNumber());
		existingOrder.setOrderItems(order.getOrderItems());
		return orderRepository.save(existingOrder);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

}
