package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.orderRequest;
import com.example.demo.model.Order1;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "Api Dokumantasyon")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	@Autowired
    private OrderItemService orderItemService;

    @PostMapping("/orders")
    public ResponseEntity<Order1> createOrder(@RequestBody Order1 order) {
    	Order1 newOrder = orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order1>> getAllOrders() {
        List<Order1> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order1> getOrderById(@PathVariable Long id) {
    	Order1 order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order1> updateOrder(@PathVariable Long id, @RequestBody Order1 order) {
    	Order1 updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
    	orderService.deleteOrder(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} 
    
    @PostMapping("/{id}/items")
    public ResponseEntity<OrderItem> createOrderItem(@PathVariable Long id,@RequestBody OrderItem orderItem) {
    	OrderItem newOrder = orderItemService.createOrderItem(id,orderItem);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
}
