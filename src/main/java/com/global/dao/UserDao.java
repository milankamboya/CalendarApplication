package com.global.dao;

import java.util.List;

import com.global.model.UserMaster;

public interface UserDao 
{
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean isEmailExisted(String email);
	
	/**
	 * 
	 * @param newUser
	 */
	public void insertNewUser(UserMaster newUser);
	
	/**
	 * 
	 * @param userName
	 */
	public List selectUserDetails(String userName);
	
}
