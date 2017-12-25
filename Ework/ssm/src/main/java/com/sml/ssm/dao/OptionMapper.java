package com.sml.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sml.ssm.pojo.Option;
import com.sml.ssm.pojo.OptionVid;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/
@Repository("optionDao")
public interface OptionMapper {
	public List<Option> selectOptionList();
	
	public void insertOption(OptionVid ov);
	
	public List<Option> selectOptionById(int v_id);
	
	public void updateCount(int o_id);
	
	public List<Option> selectOptionByOid(int o_id);
}
