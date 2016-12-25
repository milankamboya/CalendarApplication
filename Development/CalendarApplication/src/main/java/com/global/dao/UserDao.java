package com.global.dao;

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
	
}
