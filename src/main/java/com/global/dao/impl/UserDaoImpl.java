package com.global.dao.impl;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;
import java.util.Map;

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

	public List selectUserDetails(String userName) 
	{
		List<Map<String,Object>> data = hibernateDao.selectByNamedQuery("userDetailsSelectQuery", userName);
		return data;
		/*List<Object[]> data = hibernateDao.selectByNamedQuery1("userDetailsSelectQuery", userName);
		Object[] row = data.get(0);
		
		//return data;
		List userDetailList = new ArrayList();
		Map<String, String> userDetailMap = new HashMap<String, String>();
		userDetailMap.put("email", (String) row[0]);
		userDetailMap.put("password", (String)row[1]);
		userDetailMap.put("role", (String)row[2]);
		userDetailList.add(userDetailMap);
		return userDetailList;*/
	}
	
	
}
