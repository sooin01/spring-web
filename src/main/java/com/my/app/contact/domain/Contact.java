package com.my.app.contact.domain;

import java.sql.Date;

import com.my.app.common.domain.Common;

public class Contact extends Common {

	private static final long serialVersionUID = -1858367044021476913L;

	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
