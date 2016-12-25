package com.global.service;

import org.springframework.validation.Errors;

public interface Validator 
{
	public void validateSignUpForm(Object o, Errors errors);
}
