package com.sml.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sml.ssm.dao.OptionMapper;
import com.sml.ssm.dao.VoteMapper;
import com.sml.ssm.pojo.Option;
import com.sml.ssm.pojo.OptionVid;
import com.sml.ssm.pojo.Vote;
import com.sml.ssm.service.WebService;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/
@Service("webService")
public class ServiceImpl implements WebService {
	@Resource
	private OptionMapper optionDao;
	@Resource
	private VoteMapper voteDao;

	public List<Option> selectOptionList() {
		return optionDao.selectOptionList();
	}
	
	public List<Vote> selectVoteList() {
		return voteDao.selectVoteList();
	}

	public void insertOptionAndVote(String[] options,Vote vote) {
		voteDao.insertVote(vote);

		OptionVid ov = new OptionVid();
		ov.setOptions(options);
		ov.setV_id(vote.getV_id());
		
		optionDao.insertOption(ov);
	}

	public List<Option> selectOptionById(int v_id) {
		return optionDao.selectOptionById(v_id);
	}

	public void updateCount(int o_id) {
		optionDao.updateCount(o_id);
	}

	public List<Option> selectOptionByOid(int o_id) {
		return optionDao.selectOptionByOid(o_id);
	}


}
