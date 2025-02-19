package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.JobPost;
import com.main.service.JobServiceImp;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class JobRestController {
	
	@Autowired
	private JobServiceImp jobService;
	
	@GetMapping("/jobPost")
	public List<JobPost> getAllJobs() 
	{
		try
		{
			return  jobService.getAllJobs();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Problem is There");
			return null;
		}
	}
	
	@GetMapping("/jobPost/{id}")
	public JobPost getJob(@PathVariable("id") int id)
	{
		try
		{
			return jobService.getJob(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/jobPost")
	public Boolean addJob(@RequestBody JobPost jobPost)
	{
		try {
			boolean b=jobService.addJob(jobPost);
			System.out.println("JOB Added");
			return b;
		} catch (Exception e) {
			System.out.println("JOB NOT Added");
			e.printStackTrace();
			return false;
		}
	}

}
