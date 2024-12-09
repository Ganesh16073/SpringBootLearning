package com.main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {

	@RequestMapping("/Form")
	public String openForm()
	{
		System.out.println("FormController.openForm()");
		return "form.jsp";
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpSession session) // using servlet
	{
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int result=num1+num2;
		
		session.setAttribute("result",result);
		return "result.jsp";
	}
	

	
	
}
