package com.my.app.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.contact.domain.Contact;
import com.my.app.contact.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> getContactList() {
		return contactService.getContactList();
	}
	
}
