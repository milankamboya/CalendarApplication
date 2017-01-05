package com.global.common.framework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler 
{
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException exception) throws IOException, ServletException 
	{
		// Dome some code like check how many failure login attempt or to enable captcha form after 3 failed login attempt, write logic here.
		// Anything other extra stuff you want to do.
		//super.onAuthenticationFailure(request, response, exception);
		response.sendRedirect(request.getContextPath()+ "/login?error");
	}

}
