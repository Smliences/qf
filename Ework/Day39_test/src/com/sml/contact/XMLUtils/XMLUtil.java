package com.sml.contact.XMLUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	public static Document getDocment() {
		Document doc = null;
//		File file = new File("/xml/contact.xml");
		File file = new File("D:\\git\\qf\\Ework\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\Day39_test\\xml\\contact.xml");
		try {
			doc = new SAXReader().read(file);
			return doc;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e); //Exception�������ڵ�
		}
	}
	public static void writeToXML(Document doc) {
		try {
//			FileOutputStream fos = new FileOutputStream(new File("/xml/contact.xml"));
			FileOutputStream fos = new FileOutputStream(new File("D:\\\\git\\\\qf\\\\Ework\\\\.metadata\\\\.plugins\\\\org.eclipse.wst.server.core\\\\tmp2\\\\wtpwebapps\\\\Day39_test\\\\xml\\\\contact.xml"));
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(fos, format);
			writer.write(doc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
