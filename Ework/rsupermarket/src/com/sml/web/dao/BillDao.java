package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseDao;
import com.sml.web.pojo.Bill;

public interface BillDao extends BaseDao<Bill>{
	public List<Bill> queryBillList();
}
