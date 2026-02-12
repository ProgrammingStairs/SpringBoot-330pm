package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.Payment;
import com.springboot.service.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getUserByPaymentId/{paymentId}")
	public String getMessage(@PathVariable("paymentId") int paymentId) {
		return orderService.getUserDetails(paymentId);
	}
	
	@PostMapping("/addPayment")
	public String addPayment(@RequestBody Payment payment) {
		return orderService.addPayment(payment);
	}
}

