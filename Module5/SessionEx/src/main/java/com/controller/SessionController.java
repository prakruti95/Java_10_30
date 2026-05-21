package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.validator.LoginValidator;

@Controller
@SessionAttributes("login")

public class SessionController 
{
	LoginValidator loginValidator;

	public LoginValidator getLoginValidator() {
		return loginValidator;
	}

	@Autowired
	public void setLoginValidator(LoginValidator loginValidator) {
		
		this.loginValidator = loginValidator;
	}
	
	@RequestMapping(value={"/"},method=RequestMethod.GET)
	private ModelAndView index()
	{
		ModelAndView model=new ModelAndView("index","login",new Login());
		return model;
	}
	
	@RequestMapping(value={"/index"},method=RequestMethod.GET)
	private ModelAndView auth()
	{
		ModelAndView model=new ModelAndView("index","login",new Login());
		model.addObject("error", "Please Use Your Correct Cresidential");
		return model;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	private String login(@ModelAttribute  Login login,Model model,BindingResult result)
	{
		loginValidator.validate(login, result);
		
		if(result.hasErrors())
		{
			return "index";
		}
		else
		{
			model.addAttribute("login",login);
			return "success";
		}
	}
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	private String profile()
	{
		return "profile";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private String logout(HttpSession session)
	{
		System.out.println("Logout");
		session.removeAttribute("login");
		session.invalidate();
		return "redirect:/";
		
	}
	
	@ExceptionHandler(Exception.class)
	private String handleException(Model model,Exception e)
	{
		model.addAttribute("exception",e);
		return "error";
	}
	
	
	
	
	
	
}
