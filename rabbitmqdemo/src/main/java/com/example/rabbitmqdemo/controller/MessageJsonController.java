package com.example.rabbitmqdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqdemo.dto.User;
import com.example.rabbitmqdemo.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
	
	public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
		super();
		this.rabbitMQJsonProducer = rabbitMQJsonProducer;
	}
	private RabbitMQJsonProducer rabbitMQJsonProducer;
	@PostMapping("/publish")
	public ResponseEntity<String> senJsonMessage(@RequestBody User user) {
		rabbitMQJsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message sent to RabbitMQ");
		
	}

}
