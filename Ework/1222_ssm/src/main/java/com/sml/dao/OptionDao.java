package com.sml.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sml.pojo.Option;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public interface OptionDao {
	public List<Option> getOptionList();

	public void insert(MultipartFile[] img, String[] options);
	public void insertOption(Option option);
		
}
