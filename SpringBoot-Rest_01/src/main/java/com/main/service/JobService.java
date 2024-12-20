package com.main.service;

import java.util.List;

import com.main.model.JobPost;

public interface JobService {
	
	public Boolean addJob(JobPost jobPost) throws Exception;
	public List<JobPost> getAllJobs() throws Exception;

}
