package com.course.rabbitmqproducer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class MessagingConfiguration {
	/*
	 * @Value("${RABBITMQ_ADDRESS.path}") private String RABBITMQ_ADDRESS;
	 */
	private static final String RABBITMQ_ADDRESS = "amqp://yobiioxi:I4RQ-M85kx_WC22lA8T1VMpHTBs41HSC@toad.rmq.cloudamqp.com/yobiioxi";

	@Bean
	public CachingConnectionFactory rabbitConnectionFactory(RabbitProperties config) throws Exception {

		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.getRabbitConnectionFactory().setUri(RABBITMQ_ADDRESS);

		return connectionFactory;

	}

}
