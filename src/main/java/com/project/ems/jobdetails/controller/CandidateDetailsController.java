package com.project.ems.jobdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.jobdetails.domain.CandidateDetailsDomain;
import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.service.CandidateDetailsService;
import com.project.ems.jobdetails.service.LockCandidateService;

@RestController
public class CandidateDetailsController {
	@Autowired
	private CandidateDetailsService service;
	@Autowired
	private LockCandidateService lservice;
	
	@GetMapping("/candidate")
	public ResponseEntity<List<CandidateDetailsDomain> >listAll()
	{
		
		
		return new ResponseEntity<List<CandidateDetailsDomain>>(service.listAll(),HttpStatus.OK);
	}
	
	@GetMapping("/candidate/{cno}")
	public ResponseEntity<CandidateDetailsDomain> getTask (@PathVariable long cno)
	{
		return new ResponseEntity<CandidateDetailsDomain>(service.get(cno),HttpStatus.OK);
	}
	
	@GetMapping("/lockcandidate")
	public List<LockCandidateDomain> getAll()
	{
		return lservice.listAll();
	}
	@PostMapping("/candidate")
	public ResponseEntity<String> addDetails(@RequestBody CandidateDetailsDomain cd)
	{
		boolean b=service.save(cd);
		
		if(b)
		{
              return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else{
                 return new ResponseEntity<String>("failure",HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/candidate/{cno}")
	public ResponseEntity<CandidateDetailsDomain> editCandidateDetails(@PathVariable long cno)
	{
		
		
		CandidateDetailsDomain editCandidateDetails = service.editCandidateDetails(cno);

           

        return new ResponseEntity<CandidateDetailsDomain>(editCandidateDetails,HttpStatus.OK);
		

              
		
		
		
		
	}
	
	@DeleteMapping("/candidate/{cno}")
	public ResponseEntity<String> delete(@PathVariable long cno) 
	{
		
		boolean b=service.delete(cno);

        
		if(b)
		{
                 return new ResponseEntity<String>("failure",HttpStatus.OK);
		}
		else{
                 return new ResponseEntity<String>("success",HttpStatus.OK);
		}
	}
	}
