package com.global.common.framework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.global.service.UserService;

@Service
public class CustomUserService implements UserDetailsService
{
	@Autowired
	UserService userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserDetails user = userService.loadUserDetails(username);
        /*if(user==null)
        {
            throw new UsernameNotFoundException("Username not found"); 
        }*/
		return user;
	}

}
