package com.project.ems.jobdetails.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.ems.jobdetails.domain.ClientsDomain;
import com.project.ems.jobdetails.domain.JobDetailsDomain;
import com.project.ems.jobdetails.repository.ClientsRepository;
import com.project.ems.jobdetails.repository.JobDetailsRepo;


@Service
public class JobDetailsService {
	@Autowired
	private JobDetailsRepo repo;
	

	
	
	
	public List<JobDetailsDomain> listAll()
	{
		
		return repo.findAll();
	}
	
	public void save(JobDetailsDomain jd) {
		
		System.out.println(jd.getSalaryrange());
		System.out.println(jd.getWorkremotely());
		System.out.println(jd.getClient());
		System.out.println(jd.getJobtitle());
		repo.save(jd);
	}
	
	
	public List<String> listjc()
	{
		List<JobDetailsDomain> lj =null;
		List<String> l=null;
		String jt = null;
		
			
			 l=new ArrayList<String>();
			 lj = repo.findAll();
			 for(JobDetailsDomain j:lj)
			 {
				j.setRoledisplay("y");
				jt= j.getJobtitle();
				String client = j.getClient();
				 
				   String result=   jt+"-"+client;
				      
				      l.add(result);
				 
			 }
			 return l;
			
		
		
	}

	public JobDetailsDomain get(long jobid) {
		
		return repo.findById(jobid).get();
		
	}
	
	public void delete(long jobid)
	{
		repo.deleteById(jobid);
	}
}
