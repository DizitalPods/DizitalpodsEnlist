package com.project.ems.jobdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.ems.jobdetails.domain.ClientsDomain;
import com.project.ems.jobdetails.domain.JobDetailsDomain;
import com.project.ems.jobdetails.repository.ClientsRepository;
import com.project.ems.jobdetails.repository.JobDetailsRepo;


@Service
public class JobDetailsService {
	@Autowired
	private JobDetailsRepo repo;
	@Autowired
	private ClientsRepository crepo;
	
	@Autowired
	private JobDetailsDomain jd;
	
	public List<JobDetailsDomain> listAll()
	{
		
		return repo.findAll();
	}
	
	public void save(JobDetailsDomain jobdetails) {
		if(jd.getClientname().equals("Adobe"))
		{
			ClientsDomain cd = crepo.findBycname(jd.getClientname());
			jd.setClientid(cd.getClno());
		}
		else if(jd.getClientname().equals("TCS"))
		{
			ClientsDomain cd = crepo.findBycname(jd.getClientname());
			jd.setClientid(cd.getClno());
		}
		
		repo.save(jobdetails);
	}
	
	
	public List<String> listjc(@PathVariable String input)
	{
		List<JobDetailsDomain> lj =null;
		List<String> l=null;
		String jt = null;
		if(input.equals("y"))
		{
			jd.setRoledisplay("y");
			 l=new ArrayList<String>();
			 lj = repo.findAll();
			 for(JobDetailsDomain j:lj)
			 {
				jt= j.getJobtitle();
				long clientid = j.getClientid();
				 ClientsDomain cd = crepo.findById(clientid).get();
				      String cname = cd.getCname();
				      l.add(jt+cname);
				 
			 }
			 return l;
			
		}
		else 
		{
			return null;
		}
		
	}

	public JobDetailsDomain get(long jobid) {
		
		return repo.findById(jobid).get();
		
	}
	
	public void delete(long jobid)
	{
		repo.deleteById(jobid);
	}
}
