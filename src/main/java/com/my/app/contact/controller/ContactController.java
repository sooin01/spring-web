package com.my.app.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.contact.domain.Contact;
import com.my.app.contact.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@RequestMapping(value = "/contact", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Contact> getContactList() {
		System.out.println(messageSourceAccessor.getMessage("welcome"));
		return contactService.getContactList();
	}
	
}
