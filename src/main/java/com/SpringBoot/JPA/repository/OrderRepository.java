package com.SpringBoot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.JPA.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
