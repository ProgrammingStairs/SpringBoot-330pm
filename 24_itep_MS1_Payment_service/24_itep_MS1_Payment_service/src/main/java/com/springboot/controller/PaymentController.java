package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Payment;
import com.springboot.service.PaymentService;

@RestController
public class PaymentController {
	
	private PaymentService paymentService;
	public PaymentController(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
}
