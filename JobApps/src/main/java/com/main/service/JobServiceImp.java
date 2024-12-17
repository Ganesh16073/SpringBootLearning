package com.main.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.JobPost;
import com.main.repository.JobRepo;

@Service
public class JobServiceImp implements JobService{

	@Autowired
	JobRepo jobRepo;
	
	@Override
	public Boolean addJob(JobPost jobPost) throws Exception{
		
		return jobRepo.addJob(jobPost);
	}

	@Override
	public List<JobPost> getAllJobs() throws Exception {
		Comparator<JobPost> compareById=(a,b)-> a.getPostId()>b.getPostId()?1:-1; // sort based on id
		List<JobPost> copy=jobRepo.getAllJobs();
		Collections.sort(copy,compareById);
		return copy;
	}

}
