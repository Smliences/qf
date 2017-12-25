import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.dao.UserDao;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class Tets {

	@Test
	public void run() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationcontext.xml");
		UserDao dao = (UserDao) app.getBean("userDao");
		System.out.println(dao.getUserList());
		
		
	}
}
