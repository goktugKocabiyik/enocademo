package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "order1")
public class Order1 {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String orderNumber;

	@OneToMany(mappedBy = "order1", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<OrderItem> orderItems;
    

}
