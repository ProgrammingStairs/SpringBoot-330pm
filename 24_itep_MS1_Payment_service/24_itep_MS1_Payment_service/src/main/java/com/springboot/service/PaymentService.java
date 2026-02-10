package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.model.Payment;
import com.springboot.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private PaymentRepository paymentRepository;
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public Payment getById(int pid) {
		return paymentRepository.findById(pid).orElse(null);
	}
}
