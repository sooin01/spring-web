package com.my.app.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.contact.dao.ContactDao;
import com.my.app.contact.domain.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;
	
	public List<Contact> getContactList() {
		return contactDao.getContactList();
	}
	
	public Contact getContact() {
		return contactDao.getContact();
	}
	
}
