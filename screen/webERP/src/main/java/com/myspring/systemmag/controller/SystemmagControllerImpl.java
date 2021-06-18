package com.myspring.systemmag.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.service.SystemmagService;
import com.myspring.systemmag.vo.SystemmagVO;
//회사등록
@Controller("SystemmagController")
public class SystemmagControllerImpl implements SystemmagController{
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	@Autowired
	private SystemmagDAO systemmagDAO;
	
	@Override
	@RequestMapping(value="/member/addcompany.do")
	public ModelAndView addCompany(SystemmagVO company, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		StringBuffer url = request.getRequestURL();
		int result = 0;
		result = systemmagService.addCompany(systemmagVO);
		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	//조회
	@Override
	@RequestMapping(value="/member/regbasicacc.do" ,method = RequestMethod.GET)
	public ModelAndView viewCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit");
		String code = (String) request.getParameter("com_code");
		
		if(code == null || submit == null) {
			List comView = systemmagService.comView();
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			return mav;
		}
			
	    if(submit.equals("1")) { 
	    	List comView = systemmagService.comView(); 
	    	List comcom = systemmagService.comcom(code); 
	    	mav = new ModelAndView(viewName);
	    	mav.addObject("comView", comView); 
	    	mav.addObject("comcom", comcom);
	    }
			 

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
	
	@Override
	@RequestMapping(value="/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no");
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		
		systemmagService.delCom(numberary);
		
		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");
		
		return mav;
		
	}
	
	@Override 
	@RequestMapping(value="/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCompany(@ModelAttribute("") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");				
		systemmagService.updCom(systemmagVO);		
		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do?submit=1&&com_code="+systemmagVO.getGeneral_Customer_Code());
		return mav;
	}
			
}


