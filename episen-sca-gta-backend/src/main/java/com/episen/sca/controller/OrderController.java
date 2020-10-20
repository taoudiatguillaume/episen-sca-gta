package com.episen.sca.controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.episen.sca.model.Order;
import com.episen.sca.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("orders")
	public List<Order> getOrders(){
		return this.orderRepository.findAll();
	}
	
	@PostMapping("/add/order")
	public Order add_order(@RequestBody Order order){
		try(FileWriter f = new FileWriter("src/main/resources/orders.txt", true);
				BufferedWriter b = new BufferedWriter(f);
				PrintWriter p = new PrintWriter(b);){
			p.println(order.getName());
		}catch(IOException e) {e.printStackTrace();}
		
		return orderRepository.save(order);
	}
}
