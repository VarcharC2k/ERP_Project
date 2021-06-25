package com.myspring.salesmanage.salesplan.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.dao.SalesplanDAO;



@Service("salesplanService")
@Transactional(propagation = Propagation.REQUIRED)
public class SalesplanServiceImpl implements SalesplanService{

	@Autowired
	private SalesplanDAO salesplanDAO;

	//salesplan
	@Override
	public List listSalesplans() throws DataAccessException {
		List salesplanList = null;
		salesplanList = salesplanDAO.selectAllSalesplanList();
		return salesplanList;
	}//selectItemList
	
	//item
	@Override
	public List listItems() throws DataAccessException {
		List allItemList = null;
		System.out.println("리스트아이템"); 
		allItemList = salesplanDAO.selectAllItemList();
		return allItemList;
	}
	@Override
	public List submitItem(String item_code) throws DataAccessException {
		List searchItemList = null;
		searchItemList = salesplanDAO.submitItemView(item_code);
		return searchItemList;
	}//searchitem


	@Override
	public int inputNo() throws DataAccessException {
		return salesplanDAO.selCode();
		
	}
	
	@Override
	public List itemText(String item_code) throws DataAccessException {
		List additemList = null;
//		additemList = salesplanDAO.salesText(item_code);
		return additemList;
	}
	@Override
	public int addItem(ItemViewVO itemview) throws DataAccessException {
		return salesplanDAO.insertItem(itemview);
	}

	@Override
	public void removeItem(String[] planAry) throws DataAccessException {
		salesplanDAO.deletePlan(planAry);
	}

}