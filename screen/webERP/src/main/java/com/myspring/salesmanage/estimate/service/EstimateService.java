package com.myspring.salesmanage.estimate.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.estimate.vo.EstimateVO;

public interface EstimateService {

	public EstimateVO getOneCust(String custCode); //tester List
	public List submitCust(EstimateVO custCode);
	//estimate
	public List listEst() throws DataAccessException;
	public List listCor() throws DataAccessException;
	
	//cust
	public List listCust() throws DataAccessException;
	public List submitEstCust(String custCode) throws DataAccessException;
	public List submitCorCust(String custCode) throws DataAccessException;
}
