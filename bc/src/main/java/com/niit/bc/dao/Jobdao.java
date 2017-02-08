package com.niit.bc.dao;

import java.util.List;

import com.niit.bc.model.Job;
import com.niit.bc.model.JobApplication;

public interface Jobdao {

	public boolean postjob(Job job);
	
	public boolean updatejob(Job job);
	
	public List<Job> getAllVacancies();
	
	public boolean applyforjob(JobApplication jobapplication);
	
	public boolean updatejobapplication(JobApplication jobapplication);
	
	public JobApplication getJobApplication(String useremail, int jobid);

	public List<JobApplication> listAllAppliedJobs(String useremail);
}
