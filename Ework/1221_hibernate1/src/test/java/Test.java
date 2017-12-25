import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.service.UserService;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class Test {
	@org.junit.Test
	public void run() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) app.getBean("userService");
		System.out.println(service.getUserList());
	}

}
