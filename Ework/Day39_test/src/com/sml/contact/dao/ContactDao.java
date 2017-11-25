package com.sml.contact.dao;


import java.util.List;

import com.sml.contact.entity.Contact;

public interface ContactDao {
	public void addContact(Contact contact);
	
	public void deleteContactById(String id);
	
	public List<Contact> findAll();
	
	public Contact findById(String id);

	public void updateContact(Contact contact);
}
