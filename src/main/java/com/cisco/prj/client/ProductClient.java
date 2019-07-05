package com.cisco.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.cfg.AppConfig;
import com.cisco.prj.dao.ProductDaoJpaImpl;
import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;


public class ProductClient {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		ctx.register(ProductDaoJpaImpl.class);
//		ctx.register(OrderService.class);
		ctx.register(AppConfig.class);
		ctx.refresh();
		OrderService service = ctx.getBean("orderService", OrderService.class);
		Product p = new Product(0,"Camlin Marker",78.00,"pen");
		service.insertProduct(p);
		Product prd = service.getProduct(2);
		System.out.println(prd);
		System.out.println("********************");
		List<Product> products = service.getProducts();
		for(Product p1: products) {
			System.out.println(p1);
		}
		
	}

}
