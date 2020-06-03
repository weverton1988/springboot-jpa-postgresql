package com.SpringBoot.JPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.JPA.entities.Produto;
import com.SpringBoot.JPA.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id); 
		return obj.get();
	}
}
