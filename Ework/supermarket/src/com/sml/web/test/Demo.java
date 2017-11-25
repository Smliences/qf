package com.sml.web.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.xml.web.untills.JdbcUtils;

public class Demo {
	
	@Test
	public void run() {
		JdbcUtils jdbc = new JdbcUtils();
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
	
	@Test
	public void run2() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql:///supermarket?name=root&password=123";
		Connection con = DriverManager.getConnection(url);
		Statement sta = con.createStatement();
		String sql = "insert into bill(bid,bpname,bpcount,bmoney,bprname"
				+ "bpdesc,btime,bpid) values(1,'yifu','3',)";
		sta.executeUpdate(sql);
		sta.close();
		con.close();
	}
}
