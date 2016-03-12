package com.my.app.contact.dao;

import java.util.List;

import com.my.app.contact.domain.Contact;

public interface ContactDao {

	public List<Contact> getContactList();
	
	public Contact getContact();
	
}
