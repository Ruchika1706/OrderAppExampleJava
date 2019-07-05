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

import com.cisco.prj.entity.Order;
import com.cisco.prj.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;

	@RequestMapping(value = "orders", method = RequestMethod.GET)
	public @ResponseBody List<Order> getOrders() {
		return service.getOrders();
	}

	@RequestMapping(value = "orders", method = RequestMethod.POST)
	public ResponseEntity<Order> addOrder(@RequestBody Order o) {
		service.addOrder(o);
		return new ResponseEntity<>(o, HttpStatus.CREATED);
	}
}