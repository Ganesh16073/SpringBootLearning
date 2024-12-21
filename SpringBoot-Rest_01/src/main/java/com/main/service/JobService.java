package com.main.service;

import java.util.List;
import java.util.Optional;

import com.main.model.JobPost;

public interface JobService {
	
	public Boolean addJob(JobPost jobPost) throws Exception;
	public List<JobPost> getAllJobs() throws Exception;
	public JobPost getJob(int id)throws Exception;

}
