package com.orderprocessing.exception;

import java.sql.SQLException;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(SQLException sqlException) {
		super(sqlException);
	}

}
