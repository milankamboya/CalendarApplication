/**
 * Proprietary and Confidential
 * Copyright 2016-2016 GlobalVincitore.
 */

package com.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping (value="/welcome")
	public String welcomePage(ModelMap model) {
		String message = " to calendar web application";
		model.addAttribute("message", message);
		return "welcome";
	}
	
}
