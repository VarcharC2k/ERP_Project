package com.myspring.commonProduction.registOperationPerformance.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface RegistOperationPerformanceDAO {

	public List viewPop() throws DataAccessException;
	public List departmentViewPop() throws DataAccessException;
	public List selectAllRegistOperationPerformanceInfo(String startDate, String endDate)
			throws DataAccessException, ParseException;
	public List selectAllRegistOperationPerformanceInfoDetail(String number) throws DataAccessException, ParseException;
	public List<String> MaterialUse(String[] numberAry) throws DataAccessException;

}
