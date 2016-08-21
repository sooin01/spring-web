package com.my.app.contact.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.contact.dao.ContactDao;
import com.my.app.contact.domain.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;
	
	public List<Contact> getContactList() {
		contactDao.getContactList();
		
		String uuid = UUID.randomUUID().toString();
		
		Contact contact = new Contact();
		contact.setId(uuid);
		contact.setFirstName("First");
		contact.setLastName("Last");
		contact.setBirthDate("1990-10-10");
		
		contactDao.insertContact(contact);
		
		contactDao.getContactList();
		
		contactDao.deleteContact(contact);
		
		return contactDao.getContactList();
	}
	
	public Contact getContactById(Integer id) {
		return contactDao.getContactById(id);
	}
	
	public Contact getContact(Contact contact) {
		return contactDao.getContact(contact);
	}
	
}
