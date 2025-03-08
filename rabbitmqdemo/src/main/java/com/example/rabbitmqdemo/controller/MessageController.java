package com.example.rabbitmqdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqdemo.publisher.RabbiMQPublisher;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(MessageController.class);
	
	private  RabbiMQPublisher rabbiMQPublisher;
	
	public MessageController(RabbiMQPublisher rabbiMQPublisher) {
		this.rabbiMQPublisher= rabbiMQPublisher;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		rabbiMQPublisher.sendMessage(message);
		return  ResponseEntity.ok("Message Sent to Rabbitmq queue");	
		
	}

}
