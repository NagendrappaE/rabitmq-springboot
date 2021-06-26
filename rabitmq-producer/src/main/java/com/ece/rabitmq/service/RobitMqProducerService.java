package com.ece.rabitmq.service;

public interface RobitMqProducerService {
	public void send(String msg);
	
	public void sendCBSrequest(String accountNumber);

}
