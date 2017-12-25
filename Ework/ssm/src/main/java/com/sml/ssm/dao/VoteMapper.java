package com.sml.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sml.ssm.pojo.Vote;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/
@Repository("voteDao")
public interface VoteMapper {
	public List<Vote> selectVoteList();
	
	public void insertVote(Vote vote);
}
