package com.sml.web.dao.imp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sml.web.dao.BillDao;
import com.sml.web.pojo.Bill;
import com.sml.web.untills.JdbcUtils;

public class BillDaoImp implements BillDao{
	JdbcUtils jdbc = new JdbcUtils();
	@Override
	public void insert(Bill e) {
		String sql = "insert into bill(bpname,bpcount,bmoney,bprname,"
				+ "bpdesc,btime,bpid) values(?,?,?,?,?,?,?)";
		ArrayList<Object> arrs = new ArrayList<Object>();
		BigDecimal money = new BigDecimal(123);
		arrs.add("zhangsan");
		arrs.add(12);
		arrs.add(money);
		arrs.add("yifu");
		arrs.add("asdfasd");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		arrs.add(timestamp);
		arrs.add(1);
		jdbc.update(sql, arrs);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Bill e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Bill> queryBillList() {
		String sql = "select * from bill";
		ArrayList<Bill> billList = new ArrayList<Bill>();
		List<HashMap<String, Object>> list = jdbc.select(sql, null);
		for (HashMap<String, Object> hashMap : list) {
			Bill bill = new Bill();
			bill.setBpname((String)hashMap.get("bpname"));
			bill.setBid((int) hashMap.get("bid"));
			bill.setBpcount((int)hashMap.get("bpcount"));
			bill.setBpdesc((String)hashMap.get("bpdesc"));
			bill.setBpid((int)hashMap.get("bpid"));
			bill.setBprname((String)hashMap.get("bprname"));
			bill.setBtime(hashMap.get("btime").toString());
			bill.setBmoney(hashMap.get("bmoney").toString());
			bill.setIsflag((int)hashMap.get("isflag"));
			billList.add(bill);
		}
		
		if (billList != null && billList.size() > 0) {
			return billList;
		}
		return null;
	}

	@Override
	public Bill query(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
