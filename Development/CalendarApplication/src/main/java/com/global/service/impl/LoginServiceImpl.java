package com.global.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.dao.LoginDao;
import com.global.model.LoginMaster;
import com.global.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService 
{
	@Autowired
	private LoginDao loginDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.global.service.LoginService#addNewUserLoginDetails(com.global.model.LoginMaster)
	 */
	public void addNewUserLoginDetails(LoginMaster newLoginUserDetails) 
	{
		loginDao.insertNewUserLoginDetails(newLoginUserDetails);
	}

}
