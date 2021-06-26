package com.ece.rabitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ece.rabitmq.bean.AccountRequest;



@Service
public class RobitMqProducerServiceImpl implements RobitMqProducerService {

	
	@Value("${sms.rabbitmq.exchange}")
	private String smsexchange;
	
	@Value("${sms.rabbitmq.routingkey}")
	private String smsroutingkey;	
	
	
	
	@Value("${cbs.rabbitmq.exchange}")
	private String cbsexchange;
	
	@Value("${cbs.rabbitmq.routingkey}")
	private String cbsroutingkey;	
	
	@Autowired
	private AmqpTemplate rabbitTemplateRef;
	
	
	@Override
	public void send(String msg) {

		
	
		System.out.println("sending ......"+msg);
		
		rabbitTemplateRef.convertAndSend(smsexchange,smsroutingkey,msg);
	}


	@Override
	public void sendCBSrequest(String accountNumber) {

		System.out.println("sending ......"+accountNumber);
		AccountRequest req=new AccountRequest();
		
		req.setAccountNumber(Integer.valueOf(accountNumber));
		req.setAmount("200.12");
		req.setBranchName("banglore");
		req.setIfsc("INDB000001");
		req.setName("Nagendra");
		

		rabbitTemplateRef.convertAndSend(cbsexchange,cbsroutingkey,req);

		
	}

	
}
