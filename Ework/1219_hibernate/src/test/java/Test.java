import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;

import com.sml.pojo.User;

/**
 * Author: sml date: 2017年12月8日 time: 下午4:14:05
 **/

public class Test {
	private Session session;

	@Before
	public void init() {
		StandardServiceRegistry regist = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(regist).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	@After
	public void after() {
		session.close();
	}

	@org.junit.Test
	public void run1() {
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123");
		session.save(user);
	}
	@org.junit.Test
	public void run2() {
		System.out.println(session.get(User.class, 1));
	}
	@org.junit.Test
	public void run3() {
		Query<User> query = session.createQuery("from User");
		List<User> list = query.list();
		System.out.println(list);
	}
	
	@org.junit.Test
	public void run4() {
		Query query = session.createQuery("update User set username=? where id=?");
		session.beginTransaction();
		query.setString(0, "zhangsa");
		query.setInteger(1, 1);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	@org.junit.Test
	public void run5() {
		Query query = session.createQuery("delete User where id = ?");
		session.beginTransaction();
		query.setInteger(0, 1);
		query.executeUpdate();
		session.getTransaction().commit();
		
	}
	
	

}
