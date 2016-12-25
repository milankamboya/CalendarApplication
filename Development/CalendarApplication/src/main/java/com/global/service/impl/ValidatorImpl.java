package com.global.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.global.dao.UserDao;
import com.global.model.UserMaster;
import com.global.service.Validator;

@Service
@Transactional
public class ValidatorImpl implements Validator
{
	private Pattern emailPattern;
	private Matcher emailMatcher;
	private Pattern phonePattern;
	private Matcher phoneMatcher;
	private Pattern dobPattern;
	private Matcher dobMatcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONE_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
	private static final String DOB_PATTERN = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
	
	@Autowired
	public UserDao userDao;
	
	public ValidatorImpl() 
	{
		emailPattern = Pattern.compile(EMAIL_PATTERN);
		phonePattern = Pattern.compile(PHONE_PATTERN);
		dobPattern = Pattern.compile(DOB_PATTERN);
	}

	public boolean validateEmail(final String email) 
	{
		emailMatcher = emailPattern.matcher(email);
		return emailMatcher.matches();
	}
	
	public boolean validatePhone(final String phone) 
	{
		phoneMatcher = phonePattern.matcher(phone);
		return phoneMatcher.matches();
	}
	
	public boolean validateDob(final String dateOfBirth) 
	{
		dobMatcher = dobPattern.matcher(dateOfBirth);
		return dobMatcher.matches();
	}
	
	public void validateSignUpForm(Object o, Errors errors) 
	{
        UserMaster user = (UserMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfbirth", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
        
        if (user.getFirstName().length() < 2 || user.getFirstName().length() > 32) 
            errors.rejectValue("firstName", "Size.userSignUpForm.firstName");
        
        if (user.getLastName().length() < 2 || user.getLastName().length() > 32) 
            errors.rejectValue("lastName", "Size");
        
        if(!validateEmail(user.getEmail()))
			errors.rejectValue("email", "Pattern.userSignUpForm.email");
        else if (userDao.isEmailExisted(user.getEmail()))
            errors.rejectValue("email", "Duplicate.userSignUpForm.username");
        
        if(!validatePhone(user.getPhone()))
			errors.rejectValue("phone", "Pattern.userSignUpForm.phone");
        
        if(!validateDob(user.getDateOfbirth()))
			errors.rejectValue("dateOfbirth", "Pattern.userSignUpForm.dateOfbirth");
        
        
		
		/*if(user.getPhone()==null || user.getPhone().length()<=0)
			errors.rejectValue("number", "NotEmpty.userSignUpForm.number");
        
		if(user.getDateOfbirth()==null || user.getDateOfbirth().length()<=0)
			errors.rejectValue("number", "NotEmpty.userSignUpForm.dob");*/
		
        /*if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

        /*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/
    }
}
