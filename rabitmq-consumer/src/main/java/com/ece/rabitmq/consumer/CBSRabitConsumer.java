package com.ece.rabitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CBSRabitConsumer {

	@RabbitListener(queues = "${cbs.rabbitmq.queue}")
	public void  receivedCBSRequest(String cbsrequestStr) {
		
		System.out.println(" inside the receivedCBSRequest  "+cbsrequestStr);
	}
	
}
