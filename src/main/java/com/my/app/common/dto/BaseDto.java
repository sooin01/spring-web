package com.my.app.common.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.my.app.common.util.CommonUtil;

public class BaseDto implements Serializable, Cloneable {

	private static final long serialVersionUID = -3160057360649820974L;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	@Override
	public String toString() {
		return CommonUtil.toJson(this);
	}

}
