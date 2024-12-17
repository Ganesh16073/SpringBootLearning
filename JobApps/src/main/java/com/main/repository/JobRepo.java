package com.main.repository;

import java.util.ArrayList;

import java.util.List;

import com.main.model.JobPost;

public interface JobRepo {
	public List<JobPost> getAllJobs() throws Exception;
	public Boolean addJob(JobPost jobPost)throws Exception;

}
