package com.global.service;

import com.global.model.UserMaster;

public interface UserService 
{
	/**
	 * 
	 * @param email
	 */
	public void sendEmailcofirmation(String email);
	
	/**
	 * 
	 * @param newUser
	 */
	public void registerNewUser(UserMaster newUser); 
}
