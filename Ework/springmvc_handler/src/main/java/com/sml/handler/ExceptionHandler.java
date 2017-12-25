package com.sml.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/
@ControllerAdvice
public class ExceptionHandler implements HandlerExceptionResolver {
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.setViewName("index");
		return mav;
	}

}
