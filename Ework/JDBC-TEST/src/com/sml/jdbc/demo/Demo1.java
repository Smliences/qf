package com.sml.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo1 {
	@Test
	public void query() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql:///jdbc?user=root&password=123";
			Connection conn = DriverManager.getConnection(url);
			Statement sta = conn.createStatement();

			String sql = "select * from user";
			ResultSet rs = sta.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("id"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void insert() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql:///jdbc?user=root&password=123";
		Connection connection = DriverManager.getConnection(url);
		
		Statement sta = connection.createStatement();
		String sql = "insert into user(name) values('lisi')";
		int count = sta.executeUpdate(sql);
		
		System.out.println(count);
	}
	
	@Test
	public void delete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql:///jdbc?user=root&password=123";
		Connection conn = DriverManager.getConnection(url);
		 
		Statement sta = conn.createStatement();
		String sql= "delete from user where id = 1";
		int count = sta.executeUpdate(sql);
		
		System.out.println(count);
	}
}
