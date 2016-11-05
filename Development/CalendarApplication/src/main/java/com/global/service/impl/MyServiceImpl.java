package com.global.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.global.dao.MyServiceDao;
import com.global.model.LoginMaster;
import com.global.service.MyService;

@Service
public class MyServiceImpl implements MyService{

	public MyServiceDao myServiceDao;
	
	public Map getLoginData() {
		LoginMaster loginMaster = (LoginMaster) myServiceDao.getLoginData();
		Map loginMap = new HashMap();
		loginMap.put("loginuser", loginMaster.getUserName());
		loginMap.put("password", loginMaster.getPassword());
		return loginMap;
	}
	
	public MyServiceDao getMyServiceDao() {
		return myServiceDao;
	}

	public void setMyServiceDao(MyServiceDao myServiceDao) {
		this.myServiceDao = myServiceDao;
	}
}
