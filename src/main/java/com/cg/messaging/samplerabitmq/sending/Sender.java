package com.cg.messaging.samplerabitmq.sending;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {
RabbitMessagingTemplate template;
	
	@Autowired
	public Sender(RabbitMessagingTemplate template){
		this.template = template;
	}

	@Bean
	public Queue queue() {
		return new Queue("HelloQ", false);
	}
	@RequestMapping("/")
	public void send(String message){
		template.convertAndSend("HelloQ", "hai hema");
	}

}
