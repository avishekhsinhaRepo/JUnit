package com.orderprocessing.bo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orderprocessing.dao.OrderDAO;
import com.orderprocessing.dto.Order;
import com.orderprocessing.exception.BusinessException;

public class OrderBOImplTest {

	@Mock
	OrderDAO orderDAO;

	OrderBOImpl orderBOImpl = null;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		orderBOImpl = new OrderBOImpl();
		orderBOImpl.setOrderDAO(orderDAO);
	}

	@Test
	void testPlaceOrder() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.create(order)).thenReturn(1);
		assertTrue(orderBOImpl.placeOrder(order));
	}
	
	@Test
	void testFailedPlaceOrder() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.create(order)).thenReturn(0);
		assertFalse(orderBOImpl.placeOrder(order));
	}

	@Test
	void testCancelOrder() {
	}

	@Test
	void testDeleteOrder() {
	}

}
