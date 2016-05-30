/**
 * 
 */
package com.mhy.commons.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mahaiyuan
 * @since 2016年5月30日 下午11:43:46
 *
 */
public class SqlSessionFactoryUtil {

	private static Logger logger = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);
	
	public static SqlSessionFactory getSqlSessionFactory(){
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			return new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			logger.error("getSqlSessionFactory error.", e);
			return null;
		}
	}
}
