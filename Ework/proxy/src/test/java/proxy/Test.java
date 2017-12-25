package proxy;

import java.lang.reflect.Proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.proxy.UserImpl;
import com.sml.proxy.UserProxy;
import com.sml.proxy.dynamic.Student;
import com.sml.proxy.dynamic.StudentHandler;
import com.sml.proxy.dynamic.StudentImpl;
import com.sml.spring.proxy.UserDao;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Test {
	@org.junit.Test
	public void run1() {
		UserProxy proxy = new UserProxy(new UserImpl());
		proxy.eat();
		proxy.study();
	}
	
	@org.junit.Test
	public void run2() {
		Student student = new StudentImpl();
		StudentHandler handler = new StudentHandler();
		handler.setStudent(student);
		
		Student proxy = (Student) Proxy.newProxyInstance(Test.class.getClassLoader(), 
				student.getClass().getInterfaces(), handler);
		proxy.eat();
		proxy.study();

	}
	
	@org.junit.Test
	public void run3() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) app.getBean("userDao");
		dao.selectAll();
	}
}
