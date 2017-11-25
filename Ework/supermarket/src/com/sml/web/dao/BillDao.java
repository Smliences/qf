package com.sml.web.dao;

import java.util.List;

import com.sml.web.baseinterface.BaseInterface;
import com.sml.web.pojo.Bill;

public interface BillDao extends BaseInterface<Bill>{
	public List<Bill> queryBillList();
}
