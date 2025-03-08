package com.example.rabbitmqdemo.publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbiMQPublisher {

	
	private static final Logger LOGGER= LoggerFactory.getLogger(RabbiMQPublisher.class);


	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingkey;

	private RabbitTemplate rabbitTemplate;

	public  RabbiMQPublisher(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendMessage(String message) {
		LOGGER.info(String.format("message sent ->: %s", message));
		//System.out.println(String.format("message sent ->: %s", message));
		rabbitTemplate.convertAndSend(exchange, routingkey, message);

	}

}
