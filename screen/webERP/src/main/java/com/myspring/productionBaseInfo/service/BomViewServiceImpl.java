package com.myspring.productionBaseInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.productionBaseInfo.BOM.dao.bomViewDAO;
import com.myspring.productionBaseInfo.BOM.vo.RegOutSourcingPriceVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.productionBaseInfo.regDefectiveType.dao.DefectiveTypeDAO;
import com.myspring.productionBaseInfo.regDefectiveType.vo.DefectiveTypeVO;
@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)

public class BomViewServiceImpl implements BomViewService{
	@Autowired
	private bomViewDAO bomDAO;
	@Autowired
	private DefectiveTypeDAO defDAO;
	
	@Override
	public List bomView() throws DataAccessException {
		List bomList = null;
		bomList = bomDAO.viewBOM();
		return bomList;
	}

	@Override
	public List itemView1() throws DataAccessException {
		List popList = null;
		popList = bomDAO.viewPop1();
		return popList;
	}
	@Override
	public List itemView2() throws DataAccessException {
		List popList = null;
		popList = bomDAO.viewPop2();
		return popList;
	}

	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List searchList = null;
		searchList = bomDAO.setText(itemNumber);
		return searchList;
	}

	@Override
	public List SearchView(String itemNumber) throws DataAccessException {
		List searchList = null;
		searchList = bomDAO.SearchView(itemNumber);
		return searchList;
	}

	@Override
	public List itemSet() throws DataAccessException {
		List itemSet = null;
		/* itemSet = bomDAO.itemSet(); */
		return null;
	}

	@Override
	public int addBOM(bomVO bomVO) throws DataAccessException {
		return bomDAO.addBOM(bomVO);
	}
	
	@Override
	public void delBOM(String[] noary) throws DataAccessException{
		bomDAO.delBOM(noary);
	}

	@Override
	public int updateBOM(bomVO bomVO) throws DataAccessException {
		return bomDAO.updBOM(bomVO);
	}

	@Override
	public int inputNo() throws DataAccessException {
		return bomDAO.selNo();
	}

	@Override
	public List ChildView(String itemNumber,String childCode) throws DataAccessException {
		return bomDAO.childView(itemNumber,childCode);
	}

	@Override
	public List SearchOutView() throws DataAccessException {
		return bomDAO.SearchOutView();
	}

	@Override
	public List SearchOutView1(String itemNumber) throws DataAccessException {
		List outView = null;
		outView = bomDAO.searchOutView1(itemNumber);
		return outView;
	}

	@Override
	public List getoutprice(String itemNumber,String placeCode) throws DataAccessException {
		List outpriceView = null;
		outpriceView = bomDAO.getoutprice(itemNumber,placeCode);
		return outpriceView;
	}

	@Override
	public int addoutprice(RegOutSourcingPriceVO outVO) throws DataAccessException {
		return bomDAO.addoutprice(outVO);
	}

	@Override
	public List inputText(String itemCode) throws DataAccessException {
		List searchList = null;
		searchList = bomDAO.inputText(itemCode);
		return searchList;
	}

	@Override
	public int updoutprice(RegOutSourcingPriceVO outVO) throws DataAccessException {
		int updList = 0;
		updList = bomDAO.updoutprice(outVO);
		return updList;
	}

	@Override
	public int deloutprice(RegOutSourcingPriceVO outVO) throws DataAccessException {
		int delList = 0;
		delList = bomDAO.deloutprice(outVO);
		return delList;
	}

	@Override
	public List viewDefective() throws DataAccessException {
		List defView = null;
		defView = defDAO.viewDefective();
		return defView;
	}

	@Override
	public int addDefType(DefectiveTypeVO defVO) throws DataAccessException {
		return defDAO.addoutprice(defVO);
	}

	@Override
	public int updDefType(DefectiveTypeVO defVO) throws DataAccessException {
		int updList = 0;
		updList = defDAO.updDefType(defVO);
		return updList;
	}

}
