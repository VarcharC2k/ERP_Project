package com.myspring.salesmanage.order.sta.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface OrderStaService {

	
	//salesplan
	public List listOrder() throws DataAccessException;
	
	//cust
	public List listCusts() throws DataAccessException;
	public List submitCust(String custCode) throws DataAccessException;
}
