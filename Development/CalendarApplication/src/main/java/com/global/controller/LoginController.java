package com.global.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.global.model.UserMaster;
import com.global.service.MyService;

@Controller
public class LoginController {
	
	@Autowired
	MyService myService;
	
	@RequestMapping (value="/welcome")
	public String welcomePage(ModelMap model) {
		String message = " to calendar web application";
		model.addAttribute("message", message);
		model.addAttribute("logindetails", myService.getLoginData());
		return "welcome";
	}
	
	@RequestMapping (value="/doSignup")
	public String signupProcess(@ModelAttribute("signup")UserMaster user, ModelMap model) throws IOException{
		System.out.println(user.getFirstName());
		if(true)	throw new IOException("this is io exception");
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupPage(Model model) {
		UserMaster user = new UserMaster();
		model.addAttribute("userForm", user);
		return "signup";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(Model model) {
		return "error";
	}
	
}
