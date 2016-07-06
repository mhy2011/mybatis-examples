/**
 * 
 */
package com.mhy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息类
 * @author mahaiyuan
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;	//用户id
	private String username;	//用户名
	private String password;	//密码
	private Date addTime;	//创建时间
	private Date lastLoginTime;	//最后更新时间
	private int loginTimes;	//登录次数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", addTime=" + addTime
				+ ", lastLoginTime=" + lastLoginTime + ", loginTimes=" + loginTimes + "]";
	}
	
}
