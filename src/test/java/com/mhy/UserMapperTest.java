/**
 * 
 */
package com.mhy;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.mhy.commons.util.SqlSessionFactoryUtil;
import com.mhy.mapper.UserMapper;
import com.mhy.model.User;

/**
 * UserMapper测试类
 * @author mahaiyuan
 *
 */
public class UserMapperTest {

	@Test
	public void testAdd() {
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("mahaiyuan");
			user.setPassword("123456");
			user.setAddTime(new Date());
			user.setLastLoginTime(new Date());
			user.setLoginTimes(1);
			int num = mapper.add(user);
			session.commit();	//提交事务
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testAdd2() {
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("mahaiyuan2016");
			user.setPassword("111111");
			user.setAddTime(new Date());
			user.setLastLoginTime(new Date());
			user.setLoginTimes(1);
			int num = mapper.add(user);
			session.commit();	//提交事务
			System.out.println("user id = " + user.getId());
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
}
