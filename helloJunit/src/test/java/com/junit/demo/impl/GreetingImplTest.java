package com.junit.demo.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.demo.Greeting;

class GreetingImplTest {

	Greeting greeting = new GreetingImpl();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGreeting() {
		String expected = "Hello John"; 
		assertEquals(expected, greeting.greet("John"));
	}

}
