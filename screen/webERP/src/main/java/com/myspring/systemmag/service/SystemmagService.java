package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagService {
	public int addCompany(SystemmagVO systemmagVO) throws Exception;
	
	public List comView() throws DataAccessException;
	
	public List comcom(String com_code) throws DataAccessException;
	
	public void delCom(String[] noary) throws DataAccessException;
	
	public int updCom(SystemmagVO systemmagVO) throws DataAccessException;
}
