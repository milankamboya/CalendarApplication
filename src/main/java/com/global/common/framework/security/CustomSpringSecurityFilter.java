package com.global.common.framework.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class CustomSpringSecurityFilter extends GenericFilterBean 
{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null && auth.getName() != null && auth instanceof UsernamePasswordAuthenticationToken)
		{
			HttpSession session = httpRequest.getSession(false);
			String username = (String)session.getAttribute("username") == null ? null : (String)session.getAttribute("username") ;
			if(session == null || username == null)
			{
				session.invalidate();
				SecurityContextHolder.getContext().setAuthentication(null);
				SecurityContextHolder.clearContext();
				if(httpRequest.getRequestURI().equals("/CalendarApplication/"))
				{
					httpResponse.sendRedirect( httpRequest.getContextPath() + "/welcome");
					return;
				}
				else
				{
					httpResponse.sendRedirect( httpRequest.getContextPath() + "/login");
					return;
				}
				
			}
			else
			{
				if(httpRequest.getRequestURI().equals("/CalendarApplication/login"))
				{
					httpResponse.sendRedirect( httpRequest.getContextPath() + "/home");
					return;
				}
				else if(httpRequest.getRequestURI().equals("/CalendarApplication/"))
				{
					httpResponse.sendRedirect( httpRequest.getContextPath() + "/home");
					return;
				}
				
			}
			chain.doFilter(request, response);
		}
		else
		{
			if(httpRequest.getRequestURI().equals("/CalendarApplication/"))
			{
				httpResponse.sendRedirect( httpRequest.getContextPath() + "/welcome");
				return;
			}
			else
			{
				chain.doFilter(httpRequest, httpResponse);
			}
		}
	}
}