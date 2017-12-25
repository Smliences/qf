package com.sml.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sml.pojo.Vote;
import com.sml.service.Services;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@org.springframework.stereotype.Controller
public class Controller {
	@Resource
	private Services services;

	@RequestMapping("insert.action")
	public void insertOptionList(Vote vote,String[] options,@RequestParam("file") MultipartFile[] file) throws Exception {
		services.insert(vote,options,file);
	}
}
