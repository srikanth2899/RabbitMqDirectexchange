package com.course.rabbitmqproducer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.PictureProducer;

@SpringBootApplication
// @EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

	@Autowired
	private PictureProducer pictureProducer;

	private final List<String> SOURCES = Arrays.asList("mobile", "web");

	private final List<String> TYPES = Arrays.asList("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Picture p = new Picture();

			p.setName("Picture " + i);
			p.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
			p.setSource(SOURCES.get(i % SOURCES.size()));
			p.setType(TYPES.get(i % TYPES.size()));
			
			pictureProducer.sendMessage(p);
		}
	}

}
