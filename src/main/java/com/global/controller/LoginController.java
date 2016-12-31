package com.global.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global.model.LoginMaster;
import com.global.model.UserMaster;
import com.global.service.UserService;
import com.global.service.Validator;

@Controller
public class LoginController 
{
	@Autowired
	Validator validator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping (value="/welcome")
	public String welcomePage(ModelMap model) 
	{
		String message = "Global Calendar";
		model.addAttribute("message", message);
		return "welcome";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth == null? "guest" : (auth.getName() == null ? "guest" : auth.getName());
		model.addAttribute("user", name);
		return "home";
	}
	
	@RequestMapping (value="/doSignup", method = RequestMethod.POST)
	public String signupProcess(@ModelAttribute("userSignUpForm")UserMaster user, 
			BindingResult bindingResult, Model model) 
	{
		validator.validateSignUpForm(user, bindingResult);
        if (bindingResult.hasErrors())
        {
        	prepareDefaultData(model);
            return "signup";
        }
        else
        {
        	userService.registerNewUser(user);
        }
        //userService.sendEmailcofirmation(user.getEmail());
        
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/showSignupPage", method = RequestMethod.GET)
	public String signupPage(Model model) 
	{
		prepareDefaultData(model);
		UserMaster user = new UserMaster();
		model.addAttribute("userSignUpForm", user);
		return "signup";
	}

	private void prepareDefaultData(Model model) 
	{
		Map<String, String> genderList = new LinkedHashMap<String, String>();
		genderList.put("M", "Male");
		genderList.put("F", "Female");
		model.addAttribute("genderList", genderList);
		
		Map<String, String> languageList = new LinkedHashMap<String, String>();
		languageList.put("en", "English - US");
		languageList.put("fr", "French");
		model.addAttribute("languageList", languageList);
		
		Map<String, String> timezoneList = new LinkedHashMap<String, String>();
		timezoneList.put("IST", "Indian Standard TimeZone");
		timezoneList.put("PST", "Pecific Standard TimeZone");
		timezoneList.put("UST", "Universal Standard TimeZone");
		model.addAttribute("timezoneList", timezoneList);
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(Model model) 
	{
		return "error";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) 
	{
		LoginMaster lm = new LoginMaster();
		model.addAttribute("loginForm", lm);
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		return "redirect:/welcome";
	}
}
