package com.global.service;

import org.springframework.security.core.userdetails.UserDetails;

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
	
	/**
	 * 
	 * @param user
	 */
	public UserDetails loadUserDetails(String userName);
}
