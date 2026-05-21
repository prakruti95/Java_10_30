package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bean.Login;

public class LoginValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Login.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "name", "valid.name","Enter Name");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "password", "valid.password","Enter Password");
		
	}

}
