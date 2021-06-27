package com.myspring.StockManage.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.myspring.StockManage.vo.StockManageVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;


@Repository("StockManageDAO")
public class StockManageDAOImpl implements StockManageDAO {
	
	@Autowired
	SqlSession sqlSession;
	private Object serachVO;

	@Override
	public List<StockManageVO> SearchStock(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.stockView", name);
		return stockList;
	}

	@Override
	public List<StockManageVO> SearchStockAll() {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.stockViewAll");
		return stockList;
	}

	@Override
	public List<StockManageVO> SearchfinishedStockAll() {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.finishedstockViewAll");
		return stockList;
	}

	@Override
	public List SearchfinishedStock(String name) {
		List<StockManageVO> stockList = null;
		stockList = sqlSession.selectList("mappers.erp.finishedstockView", name);
		return stockList;
	}

	@Override
	public List nameView() {
		List<StockManageVO> nameList = null;
		nameList = sqlSession.selectList("mappers.erp.selectstockList");
		return nameList;
	}

	@Override
	public List<StockManageVO> viewserachPopName(String itemName) {
		List<StockManageVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopstockList",itemName);
		return popList;
	}

	@Override
	public List finishednameView() {
		List<StockManageVO> nameList = null;
		nameList = sqlSession.selectList("mappers.erp.selectfinishedstockList");
		return nameList;
	}

	@Override
	public List<StockManageVO> viewserachPopName2(String itemName) {
		List<StockManageVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopstockList2",itemName);
		return popList;
	}

	@Override
	public List cusView() {
		List<StockManageVO> nameList = null;
		nameList = sqlSession.selectList("mappers.erp.selectcusList");
		return nameList;
	}

	@Override
	public List<StockManageVO> viewserachPopCus(String itemName) {
		List<StockManageVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectPopCusList",itemName);
		return popList;
	}

	@Override
	public List<StockManageVO> Searchsuju(String customerCode) {
		List<StockManageVO> nameList = null;
		nameList = sqlSession.selectList("mappers.erp.selectsujuList",customerCode);
		return nameList;
	}

	@Override
	public List<String> selectKeywordSearch(String keyword) {
		 List<String> list=(ArrayList)sqlSession.selectList("mappers.erp.selectKeywordSearch",keyword);
		 return list;
	}

	@Override
	public String searchMenu(String searchWord) {
		String urlList = null;
		urlList = sqlSession.selectOne("mappers.erp.searchMenu", searchWord);
		return urlList;
	}



	


}