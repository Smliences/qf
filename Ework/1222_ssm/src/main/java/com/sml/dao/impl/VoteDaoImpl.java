package com.sml.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sml.dao.VoteDao;
import com.sml.pojo.Vote;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/
@Repository("voteDao")
public class VoteDaoImpl implements VoteDao{
	@Resource
	private HibernateTemplate ht;

	public void insert(Vote vote) {
//		ht.save(vote);
		System.out.println("vote");
	}
}
