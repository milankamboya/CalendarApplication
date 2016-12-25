package com.global.dao;

import com.global.model.LoginMaster;

public interface LoginDao 
{
	/**
	 * 
	 * @param newLoginUserDetails
	 */
	public void insertNewUserLoginDetails(LoginMaster newLoginUserDetails);

}
