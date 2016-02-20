package com.my.app.sample.dto;

import com.my.app.common.dto.BaseDto;
import com.my.app.sample.vo.SampleVo;

public class RequestBodySampleDto extends BaseDto {

	private static final long serialVersionUID = 4433265838721764233L;
	
	private SampleVo sampleVo;

	public SampleVo getUser() {
		return sampleVo;
	}

	public void setUser(SampleVo sampleVo) {
		this.sampleVo = sampleVo;
	}

}
