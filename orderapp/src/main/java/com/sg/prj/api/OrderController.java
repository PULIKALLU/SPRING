package com.sg.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sg.prj.dto.ReportDTO;
import com.sg.prj.entity.Order;
import com.sg.prj.service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping()
	public @ResponseBody List<Order> getOrders() {
			return service.getOrders();
	}
	
	@PostMapping()
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody String placeOrder(@RequestBody Order o) {
		 service.placeOrder(o);
		 return "order placed!!!";
	}
	
	@GetMapping("/report")
	public @ResponseBody List<ReportDTO> getReports() {
			return service.getReports();
	}
}
