package com.global.service.impl;

import static com.global.common.framework.impl.GlobalConstants.N;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global.common.framework.HelperUtils;
import com.global.dao.UserDao;
import com.global.model.LoginMaster;
import com.global.model.UserMaster;
import com.global.service.LoginService;
import com.global.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
	@Autowired
	private HelperUtils helperUtils;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginService loginService;
	
	private SecureRandom random = new SecureRandom();

	private String nextSessionId() 
	{
		return new BigInteger(130, random).toString(32);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.global.service.UserService#sendEmailcofirmation(java.lang.String)
	 */
	public void sendEmailcofirmation(String email) 
	{
		String linkUrl = "http://localhost:8080/CalendarApplication/confirmRegistration?token=" + nextSessionId() + "&email=" + email;
		
		String body = "<center style='background-color:#EEEEEE;width:33%;margin-left:33%;margin-right:33%;'>"
				+ "<h2>Calendar App</h2><h3>Please confirm your email address</h3>"
				+ "<hr style='width: 80%;' />"
				+ "Thanks for creating a Calendar account. To complete your registration, "
				+ "please confirm your email address by clicking the button below or using <a href='"+ linkUrl +"'>this link</a>.<br/><br/>"
				+ "This link will be working for the next 60 minutes. You can resend this link by going to your account settings.<br/><br/>"
				+ "<table border='0' cellspacing='0' cellpadding='0'>"
				+ "<tr>"
				+ "<td  align='center' style='-webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px;' bgcolor='#e9703e'>		  "
				+ "<a href='"+ linkUrl +"' target='_blank' style='font-size: 16px; font-family: Helvetica, Arial, sans-serif; "
				+ "color: #ffffff; text-decoration: none; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px; "
				+ "padding: 12px 18px; border: 1px solid #e9703e; display: inline-block;'>Confirm Your Email &rarr;</a>		  "
				+ "</td>"
				+ "</tr>"
				+ "</table>"
				+ "<br/><br/></center>";
		
		helperUtils.sendEmailcofirmation(email, body);
	}

	/*
	 * (non-Javadoc)
	 * @see com.global.service.UserService#registerNewUser(com.global.model.UserMaster)
	 */
	public void registerNewUser(UserMaster newUser) 
	{
		String nextSeqId = helperUtils.generateSequenceId(); 
		newUser.setUserId(nextSeqId);
		newUser.setIsIsolated(N);
		userDao.insertNewUser(newUser);
		
		LoginMaster newUserLoginObj = new LoginMaster();
		newUserLoginObj.setUserName(newUser.getEmail());
		newUserLoginObj.setPassword(newUser.getFirstName());
		newUserLoginObj.setLoginId(helperUtils.generateSequenceId());
		newUserLoginObj.setUser_Id(newUser);
		loginService.addNewUserLoginDetails(newUserLoginObj);
	}

}
