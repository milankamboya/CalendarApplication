package com.global.model;

import java.io.Serializable;

public class LoginMaster implements Serializable {
	private static final long serialVersionUID = -4435663247692533985L;

	private String loginId;
	private String userName;
	private String password;
	private UserMaster user_Id;

	public LoginMaster() {
	}

	public LoginMaster(String loginId, String userName, String password, UserMaster user) {
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.user_Id = user;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserMaster getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(UserMaster user_Id) {
		this.user_Id = user_Id;
	}

}
