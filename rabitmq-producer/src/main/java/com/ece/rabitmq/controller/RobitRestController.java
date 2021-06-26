package com.ece.rabitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.rabitmq.service.RobitMqProducerService;

@RestController
@RequestMapping("push")
public class RobitRestController {
	
	@Autowired
	
	RobitMqProducerService robitMqProducerService;
	
	@GetMapping("sms/{mobilenum}")
	public ResponseEntity pushMsq(@PathVariable ("mobilenum") String mob) {
		
		
		System.out.println("inside pushMsq"+mob);
		
		String smsTempl="Dear Customer"
				+ "Your account linked to mobile number"+mob
				+ "has been credited";
		
		robitMqProducerService.send(smsTempl);
		
		
		
		return  new ResponseEntity<>("success",HttpStatus.OK);
	}
	
	@GetMapping("cbs/{account}")

	public ResponseEntity pushCBS(@PathVariable ("account") String acNUm) {
		
		System.out.println("inside pushCBS"+acNUm);

		
		robitMqProducerService.sendCBSrequest(acNUm);
		
		return  new ResponseEntity<>("success",HttpStatus.OK);

	}

}
