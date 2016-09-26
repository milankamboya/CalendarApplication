package com.global.dao.impl;

import com.global.common.framework.HibernateDao;
import com.global.dao.MyServiceDao;
import com.global.model.LoginMaster;

public class MyServiceDaoImpl implements MyServiceDao{

	private HibernateDao hibernateDao;
	
	public Object getLoginData() {
		return hibernateDao.get(LoginMaster.class, "1");
	}
	
	public HibernateDao getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

}
