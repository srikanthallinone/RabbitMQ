package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingkey;
	
	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;
	
	@Value("${rabbitmq.routing.json.key}")
	private String jsonRoutingkey;
	
	
	@Bean
	public Queue  queue() {
		return new Queue(queue);
	}
	
	@Bean
	public TopicExchange  exchange() {
		return new TopicExchange(exchange);
	}
	
	// binding between queue  and exchange with routing key
	@Bean
	public Binding bind() {
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routingkey);
		
	}
	
	@Bean
	public Queue  jsonQueue() {
		return new Queue(jsonQueue);
	}
	
	
	@Bean
	public Binding jsonBind() {
		return BindingBuilder
				.bind(jsonQueue())
				.to(exchange())
				.with(jsonRoutingkey);
		
	}
	
	@Bean
	public MessageConverter converter() {		
		return new  Jackson2JsonMessageConverter();
		
	}
	
	@Bean
	public AmqpTemplate  amqpTemplate(ConnectionFactory connectionFactory ) {
		RabbitTemplate  rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate  ;		
	}
	
	

}
