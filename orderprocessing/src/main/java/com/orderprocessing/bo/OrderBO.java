package com.orderprocessing.bo;

import com.orderprocessing.dto.Order;
import com.orderprocessing.exception.BusinessException;

public interface OrderBO {
	public boolean placeOrder(Order order) throws BusinessException;

	public boolean cancelOrder(int orderId) throws BusinessException;

	public boolean deleteOrder(int orderId) throws BusinessException;

}
