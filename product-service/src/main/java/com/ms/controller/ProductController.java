package com.ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.Product;
import com.ms.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<?> finAll(){
		List<Product> products=productRepository.findAll();
		Map<String,Object> response=new HashMap<>();
		
		response.put("OK", true);
		if(products.size()<=0){
			response.put("message", "Sin Registros");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("products", products);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
	}
}
