package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Order1;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order1, Long> {

}

