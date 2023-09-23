package com.example.mongoDBRestApi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MongoDbRestApiApplicationTests {

	public static final Logger logger =LoggerFactory.getLogger(MongoDbRestApiApplication.class);
	
	@Test
	void contextLoads() {
		
		logger.info("This is test class runnign Dashrath");
		assertEquals(true,true);
	}

}
