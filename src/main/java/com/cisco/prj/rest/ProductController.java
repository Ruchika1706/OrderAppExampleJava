package com.cisco.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@RestController
public class ProductController {
		@Autowired
		private OrderService service;
		@RequestMapping(value="products", method=RequestMethod.GET)
		public @ResponseBody List<Product> getProducts() {
			return service.getProducts();
		}
		@RequestMapping(value="products", method=RequestMethod.POST)
		public ResponseEntity<Product> addProducts(@RequestBody Product p) {
			service.insertProduct(p);
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		}
		
		
}
