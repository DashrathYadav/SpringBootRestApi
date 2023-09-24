package com.example.mongoDBRestApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Main Application Class.
@SpringBootApplication
public class MongoDbRestApiApplication implements CommandLineRunner {
	
	// for printing output on console while bulding to check intended application is co
	public static final Logger logger =LoggerFactory.getLogger(MongoDbRestApiApplication.class);
	

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		logger.info("Hello Dashrath it is main class");
		SpringApplication.run(MongoDbRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Its my second logger dashrath");
		
		
	}

}
