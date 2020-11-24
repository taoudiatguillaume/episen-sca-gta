package com.episen.sca.controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import com.episen.sca.model.Order;
import com.episen.sca.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	FileWriter file;
	BufferedWriter output;
	private static Logger logger = Logger.getLogger(OrderController.class);

	public OrderController() {
		try {
			file = new FileWriter("orders.txt");
			output = new BufferedWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@GetMapping("orders")
	public List<Order> getOrders(){
		return this.orderRepository.findAll();
	}

	@PostMapping("/add/order")
	public Order add_order(@RequestBody Order order){
		//		try(FileWriter f = new FileWriter("orders.txt", true);
		//				BufferedWriter b = new BufferedWriter(f);
		//				PrintWriter p = new PrintWriter(b);){
		//			p.println(order.getName());
		//		}catch(IOException e) {e.printStackTrace();}

		// Writes the string to the file
		logger.info(order.getName());
		try {
			output.write(order.getName());
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return orderRepository.save(order);
	}
}
