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
		studentElement.addElement("name").setText("����");;
		studentElement.addElement("gender").setText("��");
		studentElement.addElement("grade").setText("�����1��");
		studentElement.addElement("address").setText("�������");
		
		Element studentElement1 = rootElement.addElement("Student");
		studentElement1.addAttribute("id", "2");
		studentElement1.addElement("name").setText("����");
		studentElement1.addElement("gender").setText("Ů");
		studentElement1.addElement("grade").setText("�����2��");
		studentElement1.addElement("address").setText("����Խ��");
		
	}
}
