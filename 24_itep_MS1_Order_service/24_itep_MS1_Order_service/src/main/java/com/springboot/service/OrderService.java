package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springboot.dto.Payment;
import com.springboot.dto.User;

@Service
public class OrderService {
	
	private RestTemplate restTemplate;
	
	public OrderService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getUserDetails(int paymentId) {
		 Payment payment = restTemplate.getForObject("http://localhost:8082/payment/"+paymentId, Payment.class);
		 int uid = payment.getUserId();
		 User user = restTemplate.getForObject("http://localhost:8081/findUser/"+uid, User.class);
		 return "User Details : "+user.getUid()+" "+user.getUsername()+" "+user.getEmail();
	}
	
	public String addPayment(Payment payment) {
		Payment payment1 = restTemplate.postForObject("http://localhost:8082/addPayment",payment,Payment.class);
		return "payment added successfully";
	}
	
}
