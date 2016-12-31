package com.global.common.framework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler 
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException 
    {
    	HttpSession session = request.getSession(true);
    	session.setAttribute("username", authentication.getName());
        setDefaultTargetUrl("/home");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}