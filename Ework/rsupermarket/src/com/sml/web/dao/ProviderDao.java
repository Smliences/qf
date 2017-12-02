package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseDao;
import com.sml.web.pojo.Provider;

public interface ProviderDao extends BaseDao<Provider>{
	public List<Provider> queryProviderList();
}
