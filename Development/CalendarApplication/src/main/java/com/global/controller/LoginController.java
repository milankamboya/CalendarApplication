/**
 * Proprietary and Confidential
 * Copyright 2016-2016 GlobalVincitore.
 */

package com.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
