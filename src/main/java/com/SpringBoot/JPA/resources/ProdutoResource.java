package com.SpringBoot.JPA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.JPA.entities.Produto;
import com.SpringBoot.JPA.service.ProdutoService;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findByid(@PathVariable Long id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
