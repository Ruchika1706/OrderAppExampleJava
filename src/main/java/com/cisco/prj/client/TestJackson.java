package com.cisco.prj.client;

import com.cisco.prj.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {
	public static void main(String[] args) throws Exception {
		Product p = new Product(12, "Camlin Marker", 79.00, "pen");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out,p);		
	}
}
