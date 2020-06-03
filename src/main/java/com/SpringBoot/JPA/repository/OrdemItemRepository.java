package com.SpringBoot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.JPA.entities.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long> {

}
