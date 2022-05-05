package com.osf.academyosf.resouces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductResouce {

	@GetMapping
	public ResponseEntity<Product> prodAll() {
		Product p = new Product(1, "Computador", 2022, 2000.00);
		return ResponseEntity.ok().body(p);

	}

}
