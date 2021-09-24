package com.basic.junit5_basics.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.basic.junit5_basics.service.GreetingService;

@ExtendWith(MockitoExtension.class)
class GreetingImplTest {
	
	@Mock
	GreetingService greetingService;
	
	@InjectMocks
	GreetingImpl greetingImpl;

	@Test
	void testGreet_when_param_is_null() {
		doThrow(IllegalArgumentException.class).when(greetingService).greet(null);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			greetingImpl.greet(null);
		});
	}
	
	@Test
	void testGreet_when_param_is_blank() {
		doThrow(IllegalArgumentException.class).when(greetingService).greet("");
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			greetingImpl.greet("");
		});
	}
	
	@Test
	void testGreet() {
		when(greetingService.greet("John")).thenReturn("Hello John");
		assertEquals("Hello John", greetingImpl.greet("John"));
	}

}
