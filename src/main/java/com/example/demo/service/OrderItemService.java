package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderItemRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.model.Order1;
import com.example.demo.model.OrderItem;

@Service
public class OrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderItem createOrderItem(Long id, OrderItem orderItem) {
		Order1 existingOrder = orderRepository.findById(id).orElse(null);
		if (existingOrder == null) {
			return null;
		}
		orderItem.setOrder(existingOrder);		
	    return orderItemRepository.save(orderItem);
	}
	public List<OrderItem> getAllOrderItem(){
	    return orderItemRepository.findAll();
	}
	public OrderItem getOrderItemById(Long id){
	    return orderItemRepository.findById(id).orElse(null);
	}
	public OrderItem updateOrderItem(Long id, OrderItem orderItem){
		OrderItem existingLineItem = orderItemRepository.findById(id).orElse(null);
	    if(existingLineItem == null){
	        return null;
	    }
	    existingLineItem.setName(orderItem.getName());
	    existingLineItem.setPrice(orderItem.getPrice());
	    existingLineItem.setOrder(orderItem.getOrder());
	    return orderItemRepository.save(existingLineItem);
	}
	public void deleteOrderItem(Long id){
		orderItemRepository.deleteById(id);
	}

	

}
