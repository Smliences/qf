package com.sml.contact.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.sml.contact.XMLUtils.XMLUtil;
import com.sml.contact.dao.ContactDao;
import com.sml.contact.entity.Contact;

public class ContactDaoImpl implements ContactDao{
	@Override
	public void addContact(Contact contact) {
		File file = new File("D:/soft/apache-tomcat-8.0.46/apache-tomcat-8.0.46/webapps/Day38_test1/xml/contact.xml");
		Document doc = null;

		if (!file.exists() || !file.isFile()) {
			doc = DocumentHelper.createDocument();
		}

		Element rootElement = doc.addElement("contacts");
		int hashCode = UUID.randomUUID().toString().replace("-", "").hashCode();
		Element contactElem = rootElement.addElement("contact");
		contactElem.addAttribute("id", String.valueOf(hashCode));

		contactElem.addElement("name").setText(contact.getName());
		contactElem.addElement("age").setText(contact.getAge() + "");
		contactElem.addElement("gender").setText(contact.getGender());
		contactElem.addElement("phone").setText(contact.getPhone());
		contactElem.addElement("qq").setText(contact.getQq());
		contactElem.addElement("email").setText(contact.getEmail());

		XMLUtil.writeToXML(doc);
	}

	@Override
	public void deleteContactById(String id) {
		String xpath = "//contact[@id='" + id + "']";
		Document doc = XMLUtil.getDocment();
		Element elem = (Element)doc.selectSingleNode(xpath);
		
		if (elem != null) {
			elem.detach();
		}
		XMLUtil.writeToXML(doc);
	}

	@Override
	public List<Contact> findAll() {
		Document doc = XMLUtil.getDocment();
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		ArrayList<Element> elemList = (ArrayList<Element>) doc.selectNodes("//contact");
		for (Element element : elemList) {
			Contact c = new Contact();
			c.setId(element.attributeValue("id"));
			c.setName(element.elementText("name"));
			c.setGender(element.elementText("gender"));
			c.setAge(Integer.parseInt(element.elementText("age")));
			c.setPhone(element.elementText("phone"));
			c.setQq(element.elementText("qq"));
			c.setEmail(element.elementText("email"));

			contactList.add(c);
		}
		return contactList;
	}

	@Override
	public Contact findById(String id) {
		String xpath = "//contact[@id='" + id +"']";
		Element elem = (Element)XMLUtil.getDocment().selectSingleNode(xpath);
		Contact c = null;

		if (elem != null) {
			c.setId(elem.attributeValue("id"));
			c.setName(elem.elementText("name"));
			c.setAge(Integer.valueOf(elem.elementText("age")));
			c.setGender(elem.elementText("gender"));
			c.setPhone(elem.elementText("phone"));
			c.setQq(elem.elementText("qq"));
			c.setEmail(elem.elementText("email"));
		}
		return c;
	}

	@Override
	public void updateContact(Contact contact) {
		String xpath = "//contact[@id='" + contact.getId() + "']";
		
		Document doc = XMLUtil.getDocment();
		Element elem = (Element)doc.selectSingleNode(xpath);

		if (elem != null) {
			elem.element("name").setText(contact.getName());
			elem.element("age").setText(contact.getAge() + "");
			elem.element("gender").setText(contact.getGender());
			elem.element("phone").setText(contact.getPhone());
			elem.element("qq").setText(contact.getQq());
			elem.element("email").setText(contact.getEmail());
		}
		
		XMLUtil.writeToXML(doc);
	}

}
