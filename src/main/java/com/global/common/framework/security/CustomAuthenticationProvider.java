package com.global.common.framework.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider extends DaoAuthenticationProvider implements AuthenticationProvider
{
	@Autowired
    private CustomUserService userService;
	
	public Authentication authenticate(Authentication auth) throws AuthenticationException 
	{
		String username = auth.getName();
        String password = (String) auth.getCredentials();
   
        UserDetails user = userService.loadUserByUsername(username);
   
        if (user == null || !user.getUsername().equalsIgnoreCase(username)) 
        {
        	throw new BadCredentialsException("Username not found.");
        }
   
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password, authorities);
        /*if (!password.equals(user.getPassword())) {
        	throw new BadCredentialsException("Wrong password.");
        }*/

        additionalAuthenticationChecks(user, token);
        
        return token;
	}

	public boolean supports(Class<?> arg0) 
	{
		return true;
	}

}
