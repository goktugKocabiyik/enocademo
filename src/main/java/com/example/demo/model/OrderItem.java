package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Order1 getOrder() {
		return order1;
	}
	public void setOrder(Order1 order1) {
		this.order1 = order1;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "order1_id")
    @JsonIgnore
    private Order1 order1;


}
