package com.basic.junit5_basics.service.impl;

import com.basic.junit5_basics.service.GreetingService;

public class GreetingServiceImpl implements GreetingService {

	public String greet(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}

		return "Hello " + name;
	}

}
