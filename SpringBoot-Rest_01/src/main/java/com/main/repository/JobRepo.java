package com.main.repository;

import java.util.List;
import java.util.Optional;

import com.main.model.JobPost;

public interface JobRepo {
	public List<JobPost> getAllJobs() throws Exception;
	public Boolean addJob(JobPost jobPost)throws Exception;
	public Optional<JobPost> getJob(int id)throws Exception;
}
