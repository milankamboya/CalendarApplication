/**
 * Proprietary and Confidential
 * Copyright 2016-2016 GlobalVincitore.
 */

package com.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping (value="/welcome", method = RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}
	
}
