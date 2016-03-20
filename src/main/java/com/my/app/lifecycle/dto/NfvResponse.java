package com.my.app.lifecycle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NfvResponse {

	@JsonProperty(value = "result_code")
	private int resultCode;
	@JsonProperty(value = "result_desc")
	private String resultDesc;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

}
