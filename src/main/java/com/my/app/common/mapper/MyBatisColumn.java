package com.my.app.common.mapper;

import com.my.app.common.domain.BaseDomain;

public class MyBatisColumn extends BaseDomain {

	private static final long serialVersionUID = -1772427288835169920L;
	
	private String columnName;
	private int dataType;
	private String typeName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
