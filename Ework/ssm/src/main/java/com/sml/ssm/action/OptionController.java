package com.sml.ssm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sml.ssm.pojo.Option;
import com.sml.ssm.service.WebService;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/
@Controller
public class OptionController {
	@Resource
	private WebService webService;

	@RequestMapping("/optionList")
	public ModelAndView selectOptionList(int v_id) {
		System.out.println(v_id);
		List<Option> optionList = webService.selectOptionById(v_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("optionList", optionList);

		System.out.println(optionList);
		mav.setViewName("option");
		return mav;
	}

	@RequestMapping("/updateCount")
	public String updateCount(int o_id) {
		webService.updateCount(o_id);
		return "forward:/result.action";
	}

	@RequestMapping("/result")
	public ModelAndView result(int v_id) {
		List<Option> optionList = webService.selectOptionById(v_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("optionList", optionList);
		mav.setViewName("showreslut");

		return mav;
	}
	
}
