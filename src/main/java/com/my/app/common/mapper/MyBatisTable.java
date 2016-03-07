package com.my.app.common.mapper;

import java.util.ArrayList;
import java.util.List;

import com.my.app.common.domain.BaseDomain;

public class MyBatisTable extends BaseDomain {

	private static final long serialVersionUID = 8147125071484178591L;
	
	String tableName;
	List<MyBatisColumn> column = new ArrayList<>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<MyBatisColumn> getColumn() {
		return column;
	}

	public void setColumn(MyBatisColumn column) {
		this.column.add(column);
	}

}
