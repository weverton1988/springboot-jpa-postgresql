package com.SpringBoot.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.JPA.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
