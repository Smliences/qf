package com.xml.web.untills;
//

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;

//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//提供对jdbc操作的封装类

public class JdbcUtils {

	private static String driver;

	private static String jdbcname;

	private static String jdbcpass;

	private static String jdbcurl;

	static {

		// 读取属性文件中的常量
		// 1在其他代码块方法执行前就开始加载我们常量
		// 2只加载一遍即可
		loadPro();
	}

	private static void loadPro() {
		// 是hashmap的子类，Properties也是一个键值对格式
		// Properties是属性的意思，一般用于属性文件读取，属性文件就是以.properties结尾的文件，这个文件中以键值对的形式保存数据
		// 属性文件中换行符表示多个键值对之间的分割，一个键值对中=分割键和值。并且键和值的类型必须是字符串，并且不能添加双引号
		// 解耦表现在:如果要修改字符串的值，只需呀打开属性文件进行修改，java类中不需要修改。

		Properties pro = new Properties();
		// load读取属性文件
		// ClassLoader类加载器，可以加载class文件，还可以加载classpath下的其他文件
		// java编译的时候会编译src目录的所有文件，java类会在classpath下生成对应的class文件
		// propertice不能够被编译，但是也会被直接赋值到classpath下
		// 如果在静态的代码块，不能够使用this关键，可以通过类名.class的方式获取到类对象
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

		try {
			pro.load(in);
			// 通过定义在属性文件中的键来获取值
			driver = pro.getProperty("jdbc_driver");

			jdbcname = pro.getProperty("jdbc_name");
			jdbcpass = pro.getProperty("jdbc_pass");
			jdbcurl = pro.getProperty("jdbc_url");
			System.out.println("+++++++++++++++++++++++++++");
			System.out.println(driver);
			System.out.println("+++++++++++++++++++++++++++");
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

	// 提取重复的代码
	// 针对增删改查，理想状态一个调用方法可以操作增删改查，但是查询需要返回结果集，增删改返回是一个int

	// 第一个公共方法提供增删改功能

	// delet from users where id =
	// insert into persons
	// 第一个参数是sql语句，因为sql语句中有不确定的占位符，第二个参数就是封装了不确定的占位符要替换的值
	public int update(String sql, ArrayList<Object> arrs) {
		// 1获取请求中的参数
		// 2操作数据库删除操作
		// 3删除成功重新跳转到列表

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(jdbcurl, jdbcname, jdbcpass);

			// 使用PreparedStatement传入的sql语句中可能带有一个或者多个"?"。不能确定?的个数，?表示的类型也不能确定
			PreparedStatement ps = con.prepareStatement(sql);

			for (int i = 0; i < arrs.size(); i++) {

				ps.setObject(i + 1, arrs.get(i));
			}

			int i = ps.executeUpdate();
			ps.close();
			con.close();
			return i;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return 0;
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}

	}

	// 根据sql查询语句查询的表的不同返回的数据不同
	// 一般来说查询user表返回就是list<User>，查询person表返回list<Person>
	// 我们可以不返回具体的实体类的list，而是返回一个list<HashMap>
	public List<HashMap<String, Object>> select(String sql, ArrayList<Object> arrs) {

		List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(jdbcurl, jdbcname, jdbcpass);

			// 使用PreparedStatement传入的sql语句中可能带有一个或者多个"?"。不能确定?的个数，?表示的类型也不能确定
			PreparedStatement ps = con.prepareStatement(sql);

			// 有可能只有sql语句，sql语句中没有变量，意味着没有占位符，那么setObject不需要执行
			if (arrs != null && arrs.size() != 0) {
				for (int i = 0; i < arrs.size(); i++) {

					ps.setObject(i + 1, arrs.get(i));
				}
			}

			ResultSet rs = ps.executeQuery();
			// 通过ResultSet对象获取到一个当前查询的结果集的额外信息
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取结果集中列的个数
			int count = rsmd.getColumnCount();

			while (rs.next()) {
				// 在一个循环中可以获取一条记录的所有数据,把记录的数据保存到hashmap里
				// 1需要知道结果集总共有多少列，如果知道列数，就可以循环向hash保存数据
				// 2还需要知道字段的名字
				HashMap<String, Object> map = new HashMap<String, Object>();

				for (int i = 0; i < count; i++) {

					// 循环获取每一个列名

					String columnName = rsmd.getColumnName(i + 1);

					Object value = rs.getObject(columnName);

					map.put(columnName, value);
				}

				// 一条记录组装完成之后，把完整的记录保存到list
				datas.add(map);

			}

			rs.close();
			ps.close();
			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return datas;

	}

}
