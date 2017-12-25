package com.sml.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sml.dao.OptionDao;
import com.sml.dao.VoteDao;
import com.sml.pojo.Option;
import com.sml.pojo.Vote;
import com.sml.service.Services;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@Service("services")
public class ServicesImpl implements Services{
	@Resource
	private OptionDao optionDao;
	@Resource
	private VoteDao voteDao;
	
//	public List<Option> getOptionList() {
//
//		return optionDao.getOptionList();
//	}

	public void insert(Vote vote, String[] options, MultipartFile[] imgs) throws Exception {
		voteDao.insert(vote);
		optionDao.insert(imgs,options);
	}



}
