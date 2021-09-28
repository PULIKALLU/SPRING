package com.sg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sg.prj.entity.Customer;
import com.sg.prj.entity.Product;
import com.sg.prj.service.OrderService;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

	// this method gets called once Spring container is created and initialized
	@Override
	public void run(String... args) throws Exception {
		System.out.println("******  Add Product **********");
//		addProduct();
		System.out.println("******  Get Products **********");
//		getProducts();
		System.out.println("******  Get Product by Id **********");
//		getById();
		
		System.out.println("Get Customer by email");
//		customerByEmail();
		
//		service.testLazy();
		
//		customQuery();
		modify();
	}

	private void modify() {
		Product p = service.updateProduct(999, 5);
		System.out.println(p.getName() + ", " + p.getPrice());
	}

	private void customQuery() {
		List<Product> products = service.byRange(500, 50_000);
		for(Product p : products) {
			System.out.println(p.getName() + ", " +p.getPrice());
		}
	}

	private void customerByEmail() {
		Customer c = service.getCustomerByEmail("harry@sg.com");
		System.out.println(c.getFirstName() + ", " + c.getLastName());
	}

	private void getById() {
		Product p = service.getProduct(1);
		System.out.println(p.getName() + ", " +p.getPrice());
	}

	private void getProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p.getName() + ", " +p.getPrice());
		}
	}

	private void addProduct() {
		service.addProduct(new Product(0, "Hp Laptop", 120000.00, 100));
	}

}
