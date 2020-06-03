package com.SpringBoot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.JPA.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
