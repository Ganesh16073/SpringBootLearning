package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.model.JobPost;

@Controller
public class JobController {
	
	@GetMapping({"/","home"}) // both url call this method
	public String home()
	{
		return "home"; // home.jsp
	}
	
	@GetMapping("/addjob")
	public String addJob()
	{
		return "addjob";
	}

	@PostMapping("handleForm")
	public String handleForm(JobPost jobPost)
	{
		return "success";
	}
}
