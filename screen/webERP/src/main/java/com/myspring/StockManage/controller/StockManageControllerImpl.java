package com.myspring.StockManage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.StockManage.service.StockManageService;
import com.myspring.StockManage.vo.StockManageVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;

@Controller("StockManageController")
public class StockManageControllerImpl implements StockManageController {
	@Autowired
	StockManageService stockManageservice;
	@Autowired
	StockManageVO stockVO;
	@Autowired
	SqlSession sqlSession;
	@RequestMapping(value = "/member/curinvenstat.do", method = RequestMethod.GET)
	public ModelAndView stockstatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		mav = new ModelAndView(viewName);
		String type = request.getParameter("type_name");
		String submit = request.getParameter("submit");
		
		StockManageVO searchVO = new StockManageVO();
		
			
		
		if (StringUtils.hasText(type)) {

			List<StockManageVO> stockList = null;
			stockList = stockManageservice.SearchStock(type);

			mav.addObject("stockList", stockList);
		}else {
			List<StockManageVO> stockList = null;
			stockList = stockManageservice.SearchStockAll();
			mav.addObject("stockList", stockList);
		}
		
		return mav;
		}
	@RequestMapping(value = "/member/curfinishedinvenstat.do", method = RequestMethod.GET)
	public ModelAndView finishedstockstatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		mav = new ModelAndView(viewName);
		String name = request.getParameter("type_name");
		String submit = request.getParameter("submit");
		
		StockManageVO searchVO = new StockManageVO();
		
		
			if (StringUtils.hasText(name)) {

				List<StockManageVO> stockList = null;
				stockList = stockManageservice.SearchfinishedStock(name);

				mav.addObject("stockList", stockList);
			}else {
				List<StockManageVO> stockList = null;
				stockList = stockManageservice.SearchfinishedStockAll();
				mav.addObject("stockList", stockList);
			}
		
		
		return mav;
		}
	
	@RequestMapping(value = "/member/searchtype.do", method = RequestMethod.GET)
	public ModelAndView searchtype(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List nameView = stockManageservice.nameView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("nameView", nameView);

		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/searchPopName.do", method = RequestMethod.GET)
	public ModelAndView searchPopName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<StockManageVO> popName = null;
		popName = stockManageservice.searchPopName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	} 

	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

}
