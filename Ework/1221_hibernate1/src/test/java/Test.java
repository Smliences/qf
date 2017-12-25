import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Test {
	@org.junit.Test
	public void run() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) app.getBean("userService");
		System.out.println(service.getUserList());
	}

}
