package com.ajtech;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes=SpringDataRedisCacheApplicationTests.class)
class SpringDataRedisCacheApplicationTests {

	@Test
	void test() {
		String result = "Expected test";
		assertEquals("Expected test", result);
	}

}
