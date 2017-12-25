package com.sml.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class MyHandler implements HandlerInterceptor{
	private long startTime;
	private ThreadLocal<Long> startTimeL = new ThreadLocal<Long>();
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTime = System.currentTimeMillis();
		startTimeL.set(startTime);
		System.out.println("pre");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("after");
	}


}
