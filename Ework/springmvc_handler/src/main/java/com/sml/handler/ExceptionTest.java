package com.sml.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class ExceptionTest implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		return null;
	}


}
