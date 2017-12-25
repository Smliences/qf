package com.sml.service;


import org.springframework.web.multipart.MultipartFile;

import com.sml.pojo.Option;
import com.sml.pojo.Vote;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public interface Services {
//	public List<Option> getOptionList();
//	public void insertOption(Option option);

	public void insert(Vote vote, String[] options, MultipartFile[] imgs) throws Exception;
}
