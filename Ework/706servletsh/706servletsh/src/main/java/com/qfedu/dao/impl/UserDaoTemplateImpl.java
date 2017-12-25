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

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.qfedu.commons.SqlConsts;
import com.qfedu.dao.UserDao;
import com.qfedu.pojo.Users;

public class UserDaoTemplateImpl implements UserDao {

	// 封装了sessionfatory，功能相当于session，并且会自动帮助我们完成事务操作
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public List<Users> selectUsers() {

		// 第一个参数是hql,第二个是参数

		return (List<Users>) ht.find(SqlConsts.USER_ALL, null);
	}

	@Override
	public int deleteUsers(int id) {

		Users user = new Users();
		user.setId(1);

		try {
			ht.delete(user);
			return 0;
		} catch (Exception e) {
			return 1;
		}

	}

}
