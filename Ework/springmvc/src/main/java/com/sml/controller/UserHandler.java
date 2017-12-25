package com.sml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sml.poji.User;

/**
 * @author: sml 
 * date: 2017年12月8日 
 * time: 下午4:14:05
 **/
@Controller
public class UserHandler {

	@RequestMapping("/test")
	public void test() {

	}

	@RequestMapping("/test1")
	public ModelAndView test1() {
		return null;
	}

	@RequestMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("test2", "test2");
		return "";
	}

	@RequestMapping("/test3")
	public String test3(User user) {
		return null;
	}

	@RequestMapping("/test4")
	public void test4(@RequestParam(name="username",defaultValue="") String username) {
		
	}

	@RequestMapping("/test5")
	public void test5(@CookieValue() String cookei) {
		
	}
	
}
