/**
 * 
 */
package com.mhy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@Test
	public void testInsertSelective(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("mahaiyuan2016");
			user.setPassword("111111");
			user.setAddTime(new Date());
			int num = mapper.insertSelective(user);
			session.commit();	//提交事务
			System.out.println("user id = " + user.getId());
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testBatchInsert(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = new ArrayList<User>(5);
			for(int i = 1; i < 6; i++){
				User user = new User();
				user.setUsername("用户" + i);
				user.setPassword("111111");
				user.setAddTime(new Date());
				users.add(user);
			}
			int num = mapper.batchInsert(users);	//指插入
			session.commit();	//提交事务
			Assert.assertEquals(5, num);
		} catch (Exception e) {
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testUpdate(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setId(20);
			user.setAddTime(new Date());
			user.setLastLoginTime(new Date());
			user.setLoginTimes(10);
			user.setPassword("123456");
			user.setUsername("test_001");
			int num = mapper.update(user);	//更新操作
			session.commit();	//提交事务
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void testUpdateColumn(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setId(20);
			user.setLastLoginTime(new Date());
			user.setLoginTimes(100);
			user.setPassword("111111");
			int num = mapper.updateColumn(user);	//更新操作
			session.commit();	//提交事务
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDelete(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int id = 20;
			int num = mapper.delete(id);
			session.commit();	//提交事务
			Assert.assertEquals(1, num);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();	//事务回滚
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testGet(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int id = 3;
			User user = mapper.get(id);
			Assert.assertEquals(id, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testGetList(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("用户1");
			List<User> userList = mapper.getList(user);
			Assert.assertNotNull(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testGetWithChoose(){
		SqlSession session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();	//打开Session
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("用户1");
			user.setPassword("111111");
			List<User> userList = mapper.getWithChoose(user);
			Assert.assertNotNull(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
