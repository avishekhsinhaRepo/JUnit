package com.orderprocessing.bo.impl;

import java.sql.SQLException;

import com.orderprocessing.bo.OrderBO;
import com.orderprocessing.dao.OrderDAO;
import com.orderprocessing.dto.Order;
import com.orderprocessing.exception.BusinessException;

public class OrderBOImpl implements OrderBO {

	private OrderDAO orderDAO;

	public boolean placeOrder(Order order) throws BusinessException {
		try {
			int result = orderDAO.create(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		return true;
	}

	public boolean cancelOrder(int orderId) throws BusinessException {
		try {
			Order order = orderDAO.read(orderId);
			order.setStatus("cancelled");
			int result = orderDAO.update(order);
			if(result ==0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessException(e);
		}
		return true;
	}

	public boolean deleteOrder(int orderId) throws BusinessException {
		return false;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
}
