package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.model.JobPost;
import com.main.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	@Qualifier("jobServiceImp")
	JobService jobService;
	
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
		try
		{
			if(jobService.addJob(jobPost))
			{
				System.out.println("New Job Added");
			}
			else
			{
				System.out.println("Job NOt Added");
			}
			

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went wrong At Adding New Job");
		}
		
		
		return "success";
	}
	
	@GetMapping("/viewalljobs")
	public String getAllJobs(Model model)
	{
		try
		{
			List<JobPost> list=jobService.getAllJobs();
			model.addAttribute("jobPosts",list);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Error in Fetching All Jobs");
		}
		
		return "viewalljobs";
		
	}
}
