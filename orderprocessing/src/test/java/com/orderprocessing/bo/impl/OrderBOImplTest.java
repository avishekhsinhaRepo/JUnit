package com.orderprocessing.bo.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.orderprocessing.dao.OrderDAO;
import com.orderprocessing.dto.Order;
import com.orderprocessing.exception.BusinessException;

@ExtendWith(MockitoExtension.class)
public class OrderBOImplTest {

	@Mock
	OrderDAO orderDAO;
	@InjectMocks
	OrderBOImpl orderBOImpl = null;

	

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
	void testFailedPlaceOrderException() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.create(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BusinessException.class, ()->{
			orderBOImpl.placeOrder(order);
		});
	}

	@Test
	void testCancelOrder() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.read(1)).thenReturn(order);
		when(orderDAO.update(order)).thenReturn(1);
		assertTrue(orderBOImpl.cancelOrder(1));
	}
	
	@Test
	void testCancelOrderFailed() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.read(1)).thenReturn(order);
		when(orderDAO.update(order)).thenReturn(0);
		assertFalse(orderBOImpl.cancelOrder(1));
	}
	
	@Test
	void testCancelOrderReadException() throws SQLException, BusinessException {
		Order order = new Order();
		doThrow(SQLException.class).when(orderDAO).read(1);
		Assertions.assertThrows(BusinessException.class, ()->{
			orderBOImpl.cancelOrder(1);
		});
		
	}
	
	@Test
	void testCancelOrderUpdateException() throws SQLException, BusinessException {
		Order order = new Order();
		when(orderDAO.read(1)).thenReturn(order);
		doThrow(SQLException.class).when(orderDAO).update(order);
		Assertions.assertThrows(BusinessException.class, ()->{
			orderBOImpl.cancelOrder(1);
		});
		
	}

	@Test
	void testDeleteOrder() {
	}

}
