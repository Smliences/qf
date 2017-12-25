package com.sml.ssm.service;

import java.util.List;

import com.sml.ssm.pojo.Option;
import com.sml.ssm.pojo.OptionVid;
import com.sml.ssm.pojo.Vote;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/

public interface WebService {
	public List<Option> selectOptionList();

	public List<Vote> selectVoteList();
	
	public void insertOptionAndVote(String[] options,Vote vote);	
	
	public List<Option> selectOptionById(int v_id);
	
	public void updateCount(int o_id);
	
	public List<Option> selectOptionByOid(int o_id);
}
