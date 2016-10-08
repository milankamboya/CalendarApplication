/**
 * Proprietary and Confidential
 * Copyright 2016-2016 GlobalVincitore.
 */

package com.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	//@RequestMapping (value="/signup")
	/*public String signupPage(ModelAndView model){
		UserMaster user = new UserMaster();
		//model.addAttribute("userForm", user);
		return "signup";
		
	}*/
	
	@RequestMapping (value="/signup")
	public ModelAndView signupPage() {
	      return new ModelAndView("signup", "command", new UserMaster());
	   }
	
	@RequestMapping (value="/doSignup")
	public String signupProcess(@ModelAttribute("signup")UserMaster user, ModelMap model){
		/*UserMaster user = new UserMaster();
		model.addAttribute("userForm", user);
		return "signup";*/
		System.out.println(user.getFirstName());
		return "signup";
		
	}
	
}
