/**
 * 
 */
package com.mhy.mapper;

import java.util.List;

import com.mhy.model.User;

/**
 * 用户管理映射器
 * @author mahaiyuan
 * @since 2016年5月5日 下午11:44:54
 *
 */
public interface UserMapper {

	int add(User user);
	
	/**
	 * 选择性插入数据
	 * @param user	用户信息
	 * @return
	 */
	int insertSelective(User user);
	
	/**
	 * 批量插入
	 * @param users	用户列表
	 * @return
	 */
	int batchInsert(List<User> users);
	
	/**
	 * 更新操作
	 * @param user	用户信息
	 * @return
	 */
	int update(User user);
	
	/**
	 * 更新指定的字段
	 * @param user	用户信息
	 * @return
	 */
	int updateColumn(User user);
	
	/**
	 * 删除指定id的用户信息
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 通过主键获取用户信息
	 * @param id
	 * @return
	 */
	User get(int id);
	
	/**
	 * 批量获取用户
	 * @param user
	 * @return
	 */
	List<User> getList(User user);
	
	List<User> getWithChoose(User user);
}
