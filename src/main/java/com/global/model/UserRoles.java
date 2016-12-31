package com.global.model;

import java.io.Serializable;

public class UserRoles implements Serializable
{
	private static final long serialVersionUID = 6755878859016284649L;
	
	private String userRoleId;
	private UserMaster user_Id;
	private String roleName;
	
	public UserRoles(){}
	
	public UserRoles(String userRoleId, UserMaster user, String roleName)
	{
		this.userRoleId = userRoleId;
		this.user_Id = user;
		this.roleName = roleName;
	}
	
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public UserMaster getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(UserMaster user_Id) {
		this.user_Id = user_Id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
