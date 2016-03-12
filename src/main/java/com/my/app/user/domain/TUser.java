package com.my.app.user.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "t_user")
public class TUser implements Serializable {

	private static final long serialVersionUID = 2541528842601306965L;
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_NAME")
	private String USER_NAME;
	
	@Column(name = "USER_TYPE")
	private Integer userType;
	
	@Column(name = "IS_ADMIN_YN")
	private Boolean isAdminYn;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "CREATED_AT")
	private Timestamp createdAt;
	
	@Column(name = "UPDATED_AT")
	private Timestamp updatedAt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Boolean getIsAdminYn() {
		return isAdminYn;
	}

	public void setIsAdminYn(Boolean isAdminYn) {
		this.isAdminYn = isAdminYn;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
