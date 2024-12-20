package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.JobPost;
import com.main.service.JobServiceImp;

@RestController
//@CrossOrigin(origins="http://localhost:3000)")
public class JobRestController {
	
	@Autowired
	private JobServiceImp jobService;
	
	@GetMapping("/jobPost")
	public List<JobPost> getAllJobs() 
	{
		try
		{
			return jobService.getAllJobs();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Problem is There");
			return null;
		}
		
		
	}

}
