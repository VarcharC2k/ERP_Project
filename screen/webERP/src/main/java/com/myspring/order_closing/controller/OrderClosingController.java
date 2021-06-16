package com.myspring.order_closing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.order_closing.vo.OrderClosingVO;

public interface OrderClosingController {

	ModelAndView ClosingList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView updateOrderClosing(OrderClosingVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}