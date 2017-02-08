package com.niit.bc.daoimpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.bc.dao.Jobdao;
import com.niit.bc.model.Job;
import com.niit.bc.model.JobApplication;
import com.niit.bc.model.UserBlog;

@EnableTransactionManagement
@Repository("jobDao")
public class Jobdaoimpl implements Jobdao {

	private static final Logger log = LoggerFactory.getLogger(UserBlog.class);

	@Autowired
	private SessionFactory sessionFactory;
	public Jobdaoimpl()
	{
		
	}

	public Jobdaoimpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	 
	@Transactional
	public boolean postjob(Job job) {
		try{
			sessionFactory.getCurrentSession().save(job);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	 
	@Transactional
	public boolean updatejob(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	 
	@Transactional
	public List<Job> getAllVacancies() {
		List<Job> allJobs = null;
		try{
			
			log.debug("Method => getAllVacancies() execution is starting");
			allJobs = sessionFactory.getCurrentSession().createQuery("FROM Job where status = 'V'").list();
			if(allJobs==null || allJobs.isEmpty()){
				log.debug("Record not found in Userrole table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allJobs;
	}

	 
	@Transactional
	public boolean applyforjob(JobApplication jobapplication) {
		try{
			sessionFactory.getCurrentSession().save(jobapplication);
			sessionFactory.getCurrentSession().flush();
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	 
	@Transactional
	public boolean updatejobapplication(JobApplication jobapplication) {
		try{
			sessionFactory.getCurrentSession().update(jobapplication);
		}
		catch(HibernateException ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	 
	@Transactional
	public JobApplication getJobApplication(String useremail, int jobid) {
		JobApplication obj = (JobApplication) sessionFactory.getCurrentSession().createQuery("Select * From JobApplication where useremail = '" + 
			useremail + " and job_id = " + jobid).list();
		return obj;
	}

	@SuppressWarnings("unchecked")
	 
	@Transactional
	public List<JobApplication> listAllAppliedJobs(String useremail) {
		List<JobApplication> allAppldJobs = null;
		try{
			
			log.debug("Method => getAllVacancies() execution is starting");
			allAppldJobs = sessionFactory.getCurrentSession().createQuery("FROM JobApplication where useremail = '" + 
					useremail + "'").list();
			if(allAppldJobs==null || allAppldJobs.isEmpty()){
				log.debug("Records are not found in Job applicatione table");
			}
		}
		catch(HibernateException ex){
			log.debug("Fetch Error :" + ex.getMessage());
			ex.printStackTrace();
		}
		return allAppldJobs;
	}
}