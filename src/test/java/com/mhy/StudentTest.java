/**
 * 
 */
package com.mhy;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mhy.mapper.StudentMapper;
import com.mhy.model.Student;

/**
 * @author mahaiyuan
 *
 */
public class StudentTest {

	@Test
	public void testGetStudent() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		Student student = session.selectOne("com.mhy.mapper.StudentMapper.getStudent", 1);
		System.out.println(student);
	}
	
	@Test
	public void testGetStudent2() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student student = mapper.getStudent2(1);
		System.out.println(student);
	}
	
	
	@Test
	public void testGetStudent3() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student student = mapper.getStudent3(1);
		System.out.println(student);
	}
}
