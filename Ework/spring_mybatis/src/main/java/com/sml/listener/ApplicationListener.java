package com.sml.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class ApplicationListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationcontext.xml");
		UserService userService = (UserService) app.getBean("userService");
		sce.getServletContext().setAttribute("userService", userService);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
