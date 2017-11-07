import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@SuppressWarnings("unused")
public class demo {
	public void addXml() {
		Document doc = DocumentHelper.createDocument();
		Element rootElement = doc.addElement("Students");
		Element studentElement = rootElement.addElement("Student");
		studentElement.addAttribute("id", "1");
		studentElement.addElement("name").setText("张三");;
		studentElement.addElement("gender").setText("男");
		studentElement.addElement("grade").setText("计算机1班");
		studentElement.addElement("address").setText("广州天河");
		
		Element studentElement1 = rootElement.addElement("Student");
		studentElement1.addAttribute("id", "2");
		studentElement1.addElement("name").setText("李四");
		studentElement1.addElement("gender").setText("女");
		studentElement1.addElement("grade").setText("计算机2班");
		studentElement1.addElement("address").setText("广州越秀");
		
	}
}
