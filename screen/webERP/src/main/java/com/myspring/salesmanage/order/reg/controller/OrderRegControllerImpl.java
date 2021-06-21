package com.myspring.salesmanage.order.reg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.order.reg.service.OrderRegService;
import com.myspring.salesmanage.order.vo.OrderVO;

@Controller("orderRegController")
public class OrderRegControllerImpl implements OrderRegController{

	private static final Logger logger = LoggerFactory.getLogger(OrderRegControllerImpl.class);
	
	@Autowired
	private OrderVO orderVO;
	
	@Autowired
	private OrderRegService orderService;
	   
	@Override
	@RequestMapping(value="/sales_manage/pop/regorderCust",method = RequestMethod.GET)
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List orderCustList = orderService.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderCustList", orderCustList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/regorder.do" ,method = RequestMethod.GET)
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		
		if(code == null || code.length() == 0) {
			mav = new ModelAndView(viewName);
			return mav;
		}

			List orderList = orderService.submitCust(code);
			
			mav = new ModelAndView(viewName);
			mav.addObject("orderList", orderList);

		return mav;
	}
	
	private String getViewName(HttpServletRequest request)  throws Exception{
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
