import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sml.pojo.User;

public class Test {
	@org.junit.Test
	public void select() {
		InputStream in = Test.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sessionFactory.openSession();
		
		List<User> userList = session.selectList("user.selectUserList");
		System.out.println(userList);
	}
}
