package com.microservice.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.payment.dto.PaymentDTO;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> sayHello(){
		
		return ResponseEntity.ok().body("Hello Spring Cloud GateWay, this is from Payment 1 Controller");
	}
	
	@RequestMapping(value = "/again-hello", method = RequestMethod.GET)
	public ResponseEntity<?>sayHelloAgainNur(){
		
		return ResponseEntity.ok().body("Hello Spring Cloud GateWay, this is from Payment 1 Controller Again, how are you?");
	}
	
	@RequestMapping(value = "/get-payment-details/{paymentId}", method = RequestMethod.GET)
	public ResponseEntity<?>getPaymentDetails(@PathVariable(name="paymentId") Long paymentId){
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setPaymentId(paymentId);
		paymentDTO.setPaymentAmount("1000");
		paymentDTO.setPaymentStatus( paymentId % 2 ==0 ? "success": "pending");
		System.out.println(paymentDTO.toString());
		return ResponseEntity.ok().body(paymentDTO);
	}
}
