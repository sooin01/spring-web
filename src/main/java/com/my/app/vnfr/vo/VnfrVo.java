package com.my.app.vnfr.vo;

import java.sql.Timestamp;

public class VnfrVo {

	private String id;
	private String name;
	private String nsrId;
	private Integer sequence;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNsrId() {
		return nsrId;
	}

	public void setNsrId(String nsrId) {
		this.nsrId = nsrId;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
		return name;
	}

}
