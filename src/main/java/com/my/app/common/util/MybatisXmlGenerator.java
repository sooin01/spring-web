package com.my.app.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.my.app.common.mapper.Mapper;
import com.my.app.common.mapper.MyBatisColumn;
import com.my.app.common.mapper.MyBatisTable;
import com.my.app.common.mapper.Select;

public class MybatisXmlGenerator {
	
	private XmlMapper xmlMapper;
	
	private StringBuilder mapper = new StringBuilder();

	private String url;

	private String user;

	private String password;

	public MybatisXmlGenerator() {
		JacksonXmlModule module = new JacksonXmlModule();
		module.setDefaultUseWrapper(false);
		xmlMapper = new XmlMapper(module);
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.url = "jdbc:mysql://192.168.0.10:3306/test";
			this.user = "root";
			this.password = "admin123";
		} catch (ClassNotFoundException e) {
		}
		
		mapper.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		mapper.append("\n").append("<!DOCTYPE mapper");
		mapper.append("\n\t").append("PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"");
		mapper.append("\n\t").append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
		mapper.append("\n");
	}
	
	public void generate() throws Exception {
		List<MyBatisTable> tableList = getTable();
		
		for (MyBatisTable table : tableList) {
			Mapper mapper = new Mapper();
			mapper.setNamespace(table.getTableName());
			
			List<String> columnList = new ArrayList<>();
			for (MyBatisColumn column : table.getColumn()) {
				columnList.add(column.getColumnName());
			}
			
			Select select = new Select();
			select.setId("get");
			select.setParameterType("map");
			select.setResultType("map");
			select.setQuery(String.format("\t\t\nSELECT %s\nFROM\n", columnList.stream().collect(Collectors.joining(", "))));
			mapper.setSelect(select);
			
			String xml = xmlMapper
					.writerWithDefaultPrettyPrinter()
					.writeValueAsString(mapper);
			System.out.println(xml);
			
			generateXml();
		}
	}
	
	private List<MyBatisTable> getTable() throws Exception {
		List<MyBatisTable> tableList = new ArrayList<>();
		
		Connection connection = DriverManager.getConnection(url, user, password);
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		ResultSet rsTab = databaseMetaData.getTables(connection.getCatalog(), null, null, null);
		
		while (rsTab.next()) {
			MyBatisTable table = new MyBatisTable();
			String tableName = rsTab.getString("TABLE_NAME");
			table.setTableName(tableName);
			
			ResultSet rsCol = databaseMetaData.getColumns(connection.getCatalog(), null, tableName, null);
			while (rsCol.next()) {
				String columnName = rsCol.getString("COLUMN_NAME");
				int dataType = rsCol.getInt("DATA_TYPE");
				String typeName = rsCol.getString("TYPE_NAME");
				
				MyBatisColumn column = new MyBatisColumn();
				column.setColumnName(columnName);
				column.setDataType(dataType);
				column.setTypeName(typeName);
				table.setColumn(column);
			}
			
			rsCol.close();
			
			tableList.add(table);
		}
		
		rsTab.close();
		
		return tableList;
	}
	
	private void generateXml() {
		
	}
	
	private void writeFile() throws IOException {
		File xmlFile = new File("C:/Users/kdw/Desktop/Simple.xml");
		FileOutputStream fos = new FileOutputStream(xmlFile);
		IOUtils.write(mapper.toString(), fos, "utf-8");
		fos.close();
	}
	
	public static void main(String[] args) throws Exception {
		MybatisXmlGenerator generator = new MybatisXmlGenerator();
		generator.generate();
	}
	
}
