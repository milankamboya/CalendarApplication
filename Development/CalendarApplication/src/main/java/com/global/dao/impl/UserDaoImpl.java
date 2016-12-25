package com.global.dao.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.common.framework.HibernateDao;
import com.global.dao.UserDao;
import com.global.model.UserMaster;

@Repository
@Transactional
public class UserDaoImpl implements UserDao
{
	@Autowired
	private HibernateDao hibernateDao;
	
	public boolean isEmailExisted(String email) 
	{
		String exitingEmail = (String) hibernateDao.get(UserMaster.class, email);
		return isNotEmpty(exitingEmail) ? true : false;
	}

	public void insertNewUser(UserMaster newUser) 
	{
		hibernateDao.persist(newUser);
	}
}
