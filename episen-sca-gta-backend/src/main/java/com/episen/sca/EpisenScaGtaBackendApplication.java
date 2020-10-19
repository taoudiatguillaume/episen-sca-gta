package com.episen.sca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.episen.sca.model.Order;
import com.episen.sca.repository.OrderRepository;

@SpringBootApplication
public class EpisenScaGtaBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EpisenScaGtaBackendApplication.class, args);
	}
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		this.orderRepository.save(new Order("o1"));
		this.orderRepository.save(new Order("o2"));
		this.orderRepository.save(new Order("o3"));
	}
}
