package com.ece.rabitmq;



import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	
	@Value("${sms.rabbitmq.queue}")
	String smsqueueName;

	@Value("${sms.rabbitmq.exchange}")
	String smsexchange;

	@Value("${sms.rabbitmq.routingkey}")
	private String smsroutingkey;
	
	
	@Value("${cbs.rabbitmq.queue}")
	String cbsqueueName;

	@Value("${cbs.rabbitmq.exchange}")
	String cbsexchange;

	@Value("${cbs.rabbitmq.routingkey}")
	private String cbsroutingkey;
	

	@Bean
	Queue smsqueue() {
		return new Queue(smsqueueName, false);
	}
	
	@Bean
	Queue cbsqueue() {
		return new Queue(cbsqueueName, false);
	}

	@Bean
	DirectExchange smsexchange() {
		return new DirectExchange(smsexchange);
	}
	
	@Bean
	DirectExchange cbsexchange() {
		return new DirectExchange(cbsexchange);
	}

	@Bean
	Binding smsbinding(@Qualifier("smsqueue") Queue queue, @Qualifier("smsexchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(smsroutingkey);
	}
	@Bean
	Binding cbsbinding(@Qualifier("cbsqueue") Queue queue, @Qualifier("cbsexchange") DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(cbsroutingkey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	
	@Bean
	public AmqpTemplate rabbitTemplateRef(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		
		return rabbitTemplate;
	}
}
