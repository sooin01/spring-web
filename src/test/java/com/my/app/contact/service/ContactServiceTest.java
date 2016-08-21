package com.my.app.contact.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.app.contact.domain.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/jdbc-context.xml"})
@WebAppConfiguration
public class ContactServiceTest {
	
	@Autowired
	private ContactService contactService;

	@Test
	public void testGetContactList() {
		for (Contact contact : contactService.getContactList()) {
			System.out.println(contact);
		}
	}
	
	@Test
	public void testGetContact() {
		//Contact contact = contactService.getContactById(1);
		//System.out.println(contact);
		
		Contact contact = new Contact();
		contact.setId("1");
		contact.setFirstName("Clarence");
		System.out.println(contactService.getContact(contact));
	}
	
}
