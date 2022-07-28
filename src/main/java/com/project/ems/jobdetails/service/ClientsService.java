package com.project.ems.jobdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.jobdetails.domain.ClientsDomain;
import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.repository.ClientsRepository;

@Service
public class ClientsService {
	@Autowired
	private ClientsRepository repo;
	
	public String saveclnt(ClientsDomain cd)
	{
		repo.save(cd);
		return "success";
	}
	public ClientsDomain getClnt(long cno) 
	{
		
		return repo.findById(cno).get();
	}
	public List<String> getAll()
	{
		
	          List<ClientsDomain>lc = repo.findAll();
	          List<String>   l=new ArrayList<String>();
	          
	          for(ClientsDomain c:lc)
	          {
	        	  
	        	  l.add(c.getCname());
	          }
	          return l;
	}

}
