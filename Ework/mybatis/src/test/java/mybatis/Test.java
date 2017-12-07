package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sml.mapper.UserMapper;
import com.sml.pojo.User;

public class Test {
	@org.junit.Test
	public void insert() {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybayis_config.xml");

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);

		User user = new User();
		user.setUsername("asdf");
		user.setPassword("123");

		userMapper.insertUser(user);
		session.commit();
	}
	@org.junit.Test
	public void select() {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybayis_config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		String username = "is"; 
		List<User> userList = userMapper.selectUserByUsername("%" + username + "%");
		System.out.println(userList.get(0));
	} 
	
	@org.junit.Test
	public void update() {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybayis_config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		User user = new User();
		user.setId(2);
		user.setUsername("z");
		user.setPassword("456");

		mapper.updateUser(user);
		session.commit();
	}
	
	@org.junit.Test
	public void selectUserGroupByName(String username) {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybayis_config.xml");
		SqlSessionFactory sessionFactoray = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactoray.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserGroupByName("%agn%");
		System.out.println(list);
	}
}
