package com.ece.rabitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSRabitMqConsumer {

	
	@RabbitListener(queues = "${sms.rabbitmq.queue}")
	public void receivedSMS(String smsText) {
		
		System.out.println("inside the SMSRabitMqConsumer  "+ smsText);
		
	}
	
	
}
