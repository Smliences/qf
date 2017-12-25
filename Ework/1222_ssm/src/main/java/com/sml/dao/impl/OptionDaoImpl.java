package com.sml.dao.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.sml.dao.OptionDao;
import com.sml.pojo.Option;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/
@Repository("optionDao")
public class OptionDaoImpl implements OptionDao {
	@Resource
	private HibernateTemplate ht;

	public List<Option> getOptionList() {
		return (List<Option>) ht.find("from Option");
	}

	public void insert(MultipartFile[] imgs, String[] options) {
		System.out.println("insert");
		
		for (MultipartFile img : imgs) {
			for (String string : options) {
				Option option = new Option();
				option.setContent(string);
				try {
					option.setImg(img.getBytes());
				} catch (IOException e) {
					System.out.println("1234/");
					e.printStackTrace();
				}
				ht.getSessionFactory().openSession().save(option);
			}
		}
	}

	public void insertOption(Option option) {
		

		ht.save(option);
	}

}
