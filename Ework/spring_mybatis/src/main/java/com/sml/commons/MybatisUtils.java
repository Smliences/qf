package com.sml.commons;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class MybatisUtils {
	public static SqlSession createFactory() {
		InputStream in = MybatisUtils.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		return new SqlSessionFactoryBuilder().build(in).openSession();
	}
}
