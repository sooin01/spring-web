package com.my.app.common.dao.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import org.springframework.jdbc.support.JdbcUtils;

public class DaoGeneratorTest {

	@Test
	public void daoGenerator() throws Exception {
		Map<String, String> valuesMap = new HashMap<>();
		
		File file = new File("C:/dev/workspace/spring-web/src/test/java/com/my/app/user/dao/util/DaoGenerator.xml");
		FileInputStream inputStream = new FileInputStream(file);
		String content = IOUtils.toString(inputStream);
		inputStream.close();
		
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://192.168.0.10:3306/test";
		String user = "root";
		String password = "admin123";
		Connection connection = DriverManager.getConnection(url, user, password);
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		
		// 테이블
		ResultSet rsTbl = databaseMetaData.getTables(connection.getCatalog(), null, null, null);
		while (rsTbl.next()) {
			valuesMap.clear();
			
			String tableName = rsTbl.getString("TABLE_NAME");
			valuesMap.put("table", tableName);
			
			List<String> columnList = new ArrayList<>();
			List<String> conditionList = new ArrayList<>();
			List<String> insertValueList = new ArrayList<>();
			List<String> updateValueList = new ArrayList<>();
			
			// 컬럼
			ResultSet rsCol = databaseMetaData.getColumns(connection.getCatalog(), null, tableName, null);
			while (rsCol.next()) {
				String columnName = rsCol.getString("COLUMN_NAME");
				int dataType = rsCol.getInt("DATA_TYPE");
				JDBCType jdbcType = JDBCType.valueOf(dataType);
				
				String condition = "";
				String insertValue = "";
				String updateValue = "";
				if (conditionList.size() > 0) {
					condition += "\t\t";
				}
				
				if (JdbcUtils.isNumeric(dataType)) {
					condition += String.format("<if test=\"%s != null and %s.length() > 0\">"
							+ "\n\t\t\tAND %s = ${%s}"
							+ "\n\t\t</if>",
							columnName, columnName, columnName, columnName);
					insertValue += String.format("${%s}", columnName);
					updateValue += String.format("%s = ${%s}", columnName, columnName);
				} else {
					condition += String.format("<if test=\"%s != null and %s.length() > 0\">"
							+ "\n\t\t\tAND %s = #{%s}"
							+ "\n\t\t</if>",
							columnName, columnName, columnName, columnName);
					insertValue += String.format("#{%s}", columnName);
					updateValue += String.format("%s = #{%s}", columnName, columnName);
				}
				
				if (jdbcType == JDBCType.BIT) {
					columnName = "if(" + columnName + " = 1, 'true', 'false') as " + columnName;
				} else if (jdbcType == JDBCType.TIMESTAMP) {
					columnName = "date_format(" + columnName + ",'%Y-%m-%d %H:%i:%s') as " + columnName;
				}
				
				if (columnList.size() > 0 && columnList.size() % 5 == 0) {
					columnList.add("\n\t\t\t" + columnName);
					insertValueList.add("\n\t\t\t" + insertValue);
					updateValueList.add("\n\t\t\t" + updateValue);
				} else {
					columnList.add(columnName);
					insertValueList.add(insertValue);
					if (updateValueList.size() > 0) {
						updateValueList.add("\n\t\t\t" + updateValue);
					} else {
						updateValueList.add(updateValue);
					}
				}
				
				conditionList.add(condition);
			}
			rsCol.close();
			
			String columes = columnList.stream().collect(Collectors.joining(", "));
			String conditions = conditionList.stream().collect(Collectors.joining("\n"));
			String insertValues = insertValueList.stream().collect(Collectors.joining(", "));
			String updateValues = updateValueList.stream().collect(Collectors.joining(", "));
			valuesMap.put("columns", columes);
			valuesMap.put("conditions", conditions);
			valuesMap.put("insertValues", insertValues);
			valuesMap.put("updateValues", updateValues);
			
			// xml 템플릿 merge
			StrSubstitutor sub = new StrSubstitutor(valuesMap);
			String data = sub.replace(content);
			System.out.println(data);
			
			/*if (StringUtils.isNotBlank(data)) {
				file = new File("D:/dev/xml/" + tableName + ".xml");
				FileOutputStream outputStream = new FileOutputStream(file);
				IOUtils.write(data, outputStream);
				outputStream.close();
			}*/
		}
		
		rsTbl.close();
		connection.close();
	}
	
}
