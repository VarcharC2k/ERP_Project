package com.myspring.StockManage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.StockManage.dao.StockManageDAO;
import com.myspring.StockManage.vo.StockManageVO;

@Service("StockManageService")
public class StockManageServiceImpl implements StockManageService{
	
	@Autowired
	StockManageDAO stockManageDAO;

	@Override
	public List<StockManageVO> SearchStockAll() {
		return stockManageDAO.SearchStockAll();
	}

	@Override
	public List<StockManageVO> SearchfinishedStockAll() {
		return stockManageDAO.SearchfinishedStockAll();
	}

	@Override
	public List<StockManageVO> SearchStock(String type) { 
		List popList = null;
		popList = stockManageDAO.SearchStock(type);
		
		return popList;
	}

	@Override
	public List<StockManageVO> SearchfinishedStock(String name) {
		List popList = null;
		popList = stockManageDAO.SearchfinishedStock(name);
		
		return popList;
	}

	@Override
	public List nameView() {
		List popList = null;
		popList = stockManageDAO.nameView();
		
		return popList;
	}

	@Override
	public List<StockManageVO> searchPopName(String itemName) {
		return stockManageDAO.viewserachPopName(itemName);
	}

	@Override
	public List finishednameView() {
		List popList = null;
		popList = stockManageDAO.finishednameView();
		
		return popList;
	}

	@Override
	public List<StockManageVO> searchPopName2(String itemName) {
		return stockManageDAO.viewserachPopName2(itemName);
	}





	

	
}
