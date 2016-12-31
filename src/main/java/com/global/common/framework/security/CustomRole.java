package com.global.common.framework.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomRole implements GrantedAuthority 
{
	private static final long serialVersionUID = 4176646839113610864L;
	
	String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAuthority() {
		return this.roleName;
	}
}
