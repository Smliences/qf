package com.sml.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class MyExceptionIntercept implements HandlerExceptionResolver{


	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		return null;
	}

}
