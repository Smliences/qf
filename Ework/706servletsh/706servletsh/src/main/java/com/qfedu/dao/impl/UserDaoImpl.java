package com.qfedu.dao.impl;
//

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
//

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qfedu.commons.SqlConsts;
import com.qfedu.dao.UserDao;
import com.qfedu.pojo.Users;

public class UserDaoImpl implements UserDao {

	// sf对象无需我们进行舒适化，而是提供一个属性和get set，由springioc初始化之后注入到当前对象
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Users> selectUsers() {

		// 使用hibernate进行操作

		Session session = sf.getCurrentSession();

		return session.createQuery(SqlConsts.USER_ALL).list();
	}

	@Override
	public int deleteUsers(int id) {

		Session session = sf.getCurrentSession();

		return 0;
	}

}
