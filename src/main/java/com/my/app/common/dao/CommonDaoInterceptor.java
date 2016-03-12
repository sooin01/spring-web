package com.my.app.common.dao;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({
	@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class CommonDaoInterceptor implements Interceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonDaoInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		BoundSql boundSql = ms.getBoundSql(args[1]);
		Object parameterObject = boundSql.getParameterObject();
		String bindingSql = null;
		
		if (parameterObject.getClass().isPrimitive()) {
			bindingSql = boundSql.getSql().replace("?", parameterObject.toString());
		} else if (parameterObject.getClass() == Boolean.class
				|| parameterObject.getClass() == Character.class
				|| parameterObject.getClass() == Byte.class
				|| parameterObject.getClass() == Short.class
				|| parameterObject.getClass() == Integer.class
				|| parameterObject.getClass() == Long.class
				|| parameterObject.getClass() == Float.class
				|| parameterObject.getClass() == Double.class) {
			bindingSql = boundSql.getSql().replace("?", parameterObject.toString());
		} else if (parameterObject.getClass() == String.class) {
			bindingSql = boundSql.getSql().replace("?", "'" + parameterObject.toString() + "'");
		} else {
			StringBuilder sb = new StringBuilder(boundSql.getSql());
			Map<String, String> parameterMap = BeanUtils.describe(parameterObject);
			
			for (ParameterMapping param : boundSql.getParameterMappings()) {
				String property = param.getProperty();
				int index = sb.indexOf("?");
				
				if (param.getJavaType().isPrimitive()) {
					sb.replace(index, index + 1, parameterMap.get(property));
				} else if (param.getJavaType() == Boolean.class
						|| param.getJavaType() == Character.class
						|| param.getJavaType() == Byte.class
						|| param.getJavaType() == Short.class
						|| param.getJavaType() == Integer.class
						|| param.getJavaType() == Long.class
						|| param.getJavaType() == Float.class
						|| param.getJavaType() == Double.class) {
					sb.replace(index, index + 1, parameterMap.get(property));
				} else {
					sb.replace(index, index + 1, "'" + parameterMap.get(property) + "'");
				}
			}
			bindingSql = sb.toString();
		}
		
		logger.info(" ==>  Preparing: {}", bindingSql.replaceAll("\\s+", " "));
		
		Object proceed = invocation.proceed();
		
		return proceed;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		logger.info("properties => {}", properties);
		
	}

}
