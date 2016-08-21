package com.my.app.contact.dao;

import java.util.List;

import com.my.app.contact.domain.Contact;

public interface ContactDao {

	public List<Contact> getContactList();
	
	public Contact getContactById(Integer id);
	
	public Contact getContact(Contact contact);
	
	public int insertContact(Contact contact);
	
	public int deleteContact(Contact contact);
	
}
