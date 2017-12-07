package fenye;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sml.mapper.UserMapper;
import com.sml.pojo.User;

public class Test {
	@org.junit.Test
	public void select() {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory sessionFactroy = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactroy.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> userList = userMapper.selectAll();
		System.out.println(userList);
		
	}
}
