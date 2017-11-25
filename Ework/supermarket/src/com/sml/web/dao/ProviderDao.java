package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseInterface;
import com.sml.web.pojo.Provider;

public interface ProviderDao extends BaseInterface<Provider>{
	public List<Provider> queryProviderList();
}
