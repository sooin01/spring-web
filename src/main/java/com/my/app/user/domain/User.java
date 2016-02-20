package com.my.app.user.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.my.app.common.domain.BaseDomain;

@Entity
public class User extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -106921400340070119L;

	@Id
	private String host;

	@Id
	private String user;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
