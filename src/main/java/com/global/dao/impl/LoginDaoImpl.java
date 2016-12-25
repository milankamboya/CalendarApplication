package com.global.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.common.framework.HibernateDao;
import com.global.dao.LoginDao;
import com.global.model.LoginMaster;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao 
{
	@Autowired
	private HibernateDao hibernateDao;

	/*
	 * (non-Javadoc)
	 * @see com.global.dao.LoginDao#insertNewUserLoginDetails(com.global.model.LoginMaster)
	 */
	public void insertNewUserLoginDetails(LoginMaster newLoginUserDetails) 
	{
		hibernateDao.persist(newLoginUserDetails);
	}

}
