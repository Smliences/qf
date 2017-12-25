package com.sml.ssm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sml.ssm.pojo.Option;
import com.sml.ssm.pojo.Vote;
import com.sml.ssm.service.WebService;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/
@org.springframework.stereotype.Controller
public class VoteController {
	@Resource
	private WebService webService;

	@RequestMapping("/index")
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView();
		List<Vote> voteList = webService.selectVoteList();
		mav.addObject(voteList);
		mav.setViewName("index");
		PageInfo<Vote> pageInfo = new PageInfo<Vote>(voteList);
		
		return mav;
	}
	@RequestMapping("/add")
	public String toAdd() {
		return "add";
	}
	
	@RequestMapping("/insert")
	public String insertVoteAndOption(Vote vote,String[] options) {
		webService.insertOptionAndVote(options, vote);
		return "redirect:/index.action";
	}
}
