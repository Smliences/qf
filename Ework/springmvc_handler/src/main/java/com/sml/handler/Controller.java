package com.sml.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/
@ControllerAdvice
public class Controller {
	@ExceptionHandler(value=Exception.class)
	public Controller() {
		// TODO Auto-generated constructor stub
	}

}
