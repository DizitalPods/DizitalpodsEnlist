package com.project.ems.jobdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.jobdetails.domain.ClientsDomain;
import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.service.ClientsService;


@RestController
public class ClientsController {
	@Autowired
	private ClientsService cs;
	
	@PostMapping("/client")
	public String saveClient(@RequestBody ClientsDomain cd )
	{
		return cs.saveclnt(cd);
		
	}
	
	@GetMapping("/client/{cno}")
	public ClientsDomain get (@PathVariable long cno)
	{
		return cs.getClnt(cno);
	}

	@GetMapping("/clients")
	public List<String> getAll()
	{
		return cs.getAll();
	}
	
}
