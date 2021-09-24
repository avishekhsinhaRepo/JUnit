package com.basic.junit5_basics.impl;

import com.basic.junit5_basics.Greeting;
import com.basic.junit5_basics.service.GreetingService;

public class GreetingImpl implements Greeting {

	GreetingService greetingService;
	
	public String greet(String name) {
		return greetingService.greet(name);
	}

}
