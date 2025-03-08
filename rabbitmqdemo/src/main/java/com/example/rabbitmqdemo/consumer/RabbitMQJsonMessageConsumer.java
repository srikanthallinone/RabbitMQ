package com.example.rabbitmqdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonMessageConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonMessageConsumer.class);

	@RabbitListener(queues= {"${rabbitmq.queue.json.name}"})
	public void consume(User user) {
		LOGGER.info(String.format("REceived JSON message is::: %s", user.toString()));

	}

}
