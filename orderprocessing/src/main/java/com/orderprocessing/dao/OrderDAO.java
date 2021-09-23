package com.orderprocessing.dao;

import java.sql.SQLException;

import com.orderprocessing.dto.Order;

public interface OrderDAO {
	int create(Order order) throws SQLException;

	int update(Order order) throws SQLException;

	int delete(int orderId) throws SQLException;

	Order read(int orderId) throws SQLException;

}
