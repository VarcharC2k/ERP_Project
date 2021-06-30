package com.myspring.systemmag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.vo.SystemmagVOMJ;

public interface SystemmagControllerMJ {
	//일반거래처등록
	public ModelAndView addCustomer (@ModelAttribute("company") SystemmagVOMJ company,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateCustomer(SystemmagVOMJ systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupZipCustomer(SystemmagVOMJ systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	//창고/공정/외주공정등록
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupOutware1(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupOutware2(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupOutware3(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//물류관리내역등록
	public ModelAndView viewLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView addLogistics(@ModelAttribute("logis") SystemmagVOMJ systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateLogistics(SystemmagVOMJ systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//검사유형등록
	public ModelAndView addInspection (@ModelAttribute("ins") SystemmagVOMJ company,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewInspection(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteInspection(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateInspection(SystemmagVOMJ systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
			
}
