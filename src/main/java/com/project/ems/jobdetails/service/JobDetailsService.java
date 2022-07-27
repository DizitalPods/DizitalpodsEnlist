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
	
	@Autowired
	private ClientsRepository crepo;
	
	String clientname =null;
	
	public List<JobDetailsDomain> listAll()
	{
		
		return repo.findAll();
	}
	
	public void save(JobDetailsDomain jd) {
		if(jd.getClientname().equals("Adobe"))
		{
			clientname =jd.getClientname();
			
			ClientsDomain cd = crepo.findBycname(clientname);
			jd.setClientid(cd.getClno());
		}
		else if(jd.getClientname().equals("TCS"))
		{
			clientname =jd.getClientname();
			ClientsDomain cd = crepo.findBycname(clientname);
			jd.setClientid(cd.getClno());
		}
		
		repo.save(jd);
	}
	
	
	public List<String> listjc(String input)
	{
		List<JobDetailsDomain> lj =null;
		List<String> l=null;
		String jt = null;
		if(input.equals("y"))
		{
			
			 l=new ArrayList<String>();
			 lj = repo.findAll();
			 for(JobDetailsDomain j:lj)
			 {
				j.setRoledisplay("y");
				jt= j.getJobtitle();
				long clientid = j.getClientid();
				 ClientsDomain cd = crepo.findById(clientid).get();
				      String cname = cd.getCname();
				   String result=   jt+"-"+cname;
				      
				      l.add(result);
				 
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
