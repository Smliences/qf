package com.sml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/
@Controller
public class UserController {

	@RequestMapping("/login")
	public void login() {
		System.out.println("login");
	}
}
