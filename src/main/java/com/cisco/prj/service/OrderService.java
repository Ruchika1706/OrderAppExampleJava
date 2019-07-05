package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.OrderDao;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Item;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	@Transactional
	public void insertProduct(Product p) {
		productDao.addProduct(p);
		//throw new IllegalArgumentException();
	}
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}
	@Transactional
	public void addOrder(Order o) {
		orderDao.placeOrder(o); // saves all items also [ Cascade ] 
		List<Item> items = o.getItems();
		for(Item i: items) {
			Product p = productDao.getProduct(i.getProduct().getId());
			p.setCount(p.getCount()-i.getQty());
		}
		//throw new IllegalArgumentException();
	}
	public List<Order> getOrders() {
		return orderDao.getOrders(); //FETCH EAGER 
	}


}
