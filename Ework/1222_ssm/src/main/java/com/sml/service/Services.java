package com.sml.service;


import org.springframework.web.multipart.MultipartFile;

import com.sml.pojo.Option;
import com.sml.pojo.Vote;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public interface Services {
//	public List<Option> getOptionList();
//	public void insertOption(Option option);

	public void insert(Vote vote, String[] options, MultipartFile[] imgs) throws Exception;
}
