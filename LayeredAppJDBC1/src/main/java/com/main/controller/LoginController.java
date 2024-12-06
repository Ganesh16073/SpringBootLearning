package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.main.model.Login;
import com.main.service.IEmployeeService;

@Controller
@Scope("prototype")
public class LoginController {
	
	

	public LoginController() {
		System.out.println("LoginController.LoginController()");
	}


	@Autowired
	private IEmployeeService service;
	
	
	public Boolean isValidLogin(Login lg)throws Exception
	{
		return service.checkValidLogin(lg);
	}
}
