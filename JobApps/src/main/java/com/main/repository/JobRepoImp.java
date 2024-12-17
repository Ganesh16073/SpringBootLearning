package com.main.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.JobPost;

@Repository
public class JobRepoImp implements JobRepo{

	private static String GET_ALL_JOBS="Select * from jobPost";
	private static String ADD_NEW_JOB="insert into jobPost value ('0',?,?,?,?)";
	
	private List<JobPost> list=new ArrayList<>();
//	Arrays.asList(new JobPost(10,"Java Developer","Spring Boot Must",1, List.of("Java","SqL")))
	
	@Autowired
	public DataSource ds;
	

			
	@Override
	public List<JobPost> getAllJobs() throws Exception
	{
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_ALL_JOBS);)
		{
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
					JobPost jp=new JobPost();
					jp.setPostId(rs.getInt(1));
					jp.setPostProfile(rs.getString(2));
					jp.setPostDesc(rs.getString(3));
					jp.setReqExperience(rs.getInt(4));
					
					String techStackJson=rs.getString("postTechStack");
					List<String> techStack=parseJsonToList(techStackJson);
					jp.setPostTechStack(techStack);
					list.add(jp);
				}
			}
		}catch (Exception e) {
		     throw e; 
		}
		
		return new ArrayList<>(list);
	}

	@Override
	public Boolean addJob(JobPost jobPost) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(ADD_NEW_JOB);)
		{
			ps.setString(1, jobPost.getPostProfile());
			ps.setString(2, jobPost.getPostDesc());
			ps.setInt(3, jobPost.getReqExperience());
			ObjectMapper mapper = new ObjectMapper();
			String techStackJson = mapper.writeValueAsString(jobPost.getPostTechStack());
			ps.setString(4, techStackJson);
			int val=ps.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
			
		}catch (Exception e) {
			throw e;
			
		}
	
	}
	
	private List<String> parseJsonToList(String json) {
	    try {
	        // Using Jackson's ObjectMapper to parse JSON
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(json, new TypeReference<List<String>>() {});
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ArrayList<>(); // Return an empty list in case of parsing failure
	    }
	}
}
