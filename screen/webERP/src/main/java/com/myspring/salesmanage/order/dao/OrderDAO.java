package com.myspring.salesmanage.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.order.vo.OrderVO;

public interface OrderDAO {
	
	//sta
	public List selectOrderCorList() throws DataAccessException;
	public List submitOrdCust(String custCode) throws DataAccessException;
	
	//reg
	public List RegOrderList() throws DataAccessException;
	public List selectAllCustList() throws DataAccessException;
	public List submitOrderCust(String custCode) throws DataAccessException;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	//reg-delete
//	public int selOrdCode() throws DataAccessException;
//	public void delOrder(String[] noary) throws DataAccessException;
//	
//	//reg-insert
//	public int addOrder(OrderVO orderVO) throws DataAccessException;
//	public List selectLine(String custCode) throws DataAccessException;
//
////	public int updNewOrder(String custCode) throws DataAccessException;
//	
////	public List selectItemGroupList() throws DataAccessException;
////	public List addGroup(String groupcode) throws DataAccessException;
////	public List submitGroupView(String groupcode) throws DataAccessException;

}