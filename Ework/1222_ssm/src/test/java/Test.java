import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sml.dao.OptionDao;
import com.sml.pojo.Option;

import javassist.bytecode.ByteArray;

/**
 * Author: sml
 * date: 2017年12月8日
 * time: 下午4:14:05
**/

public class Test {

	@org.junit.Test
	public void run1() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		OptionDao dao = (OptionDao) app.getBean("optionDao");
		Option option = new Option();
		byte[] bytes = new String("123").getBytes();
		option.setImg(bytes);
		dao.insertOption(option);
	}
}
