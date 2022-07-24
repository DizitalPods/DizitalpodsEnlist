package com.project.ems.jobdetails.controller;

import java.util.ArrayList;
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

import com.project.ems.jobdetails.domain.JobDetailsDomain;
import com.project.ems.jobdetails.service.JobDetailsService;


@RestController
public class JobDetailsController {
	@Autowired
	private JobDetailsService service;
	
	@GetMapping("/")
	public List<JobDetailsDomain> listAll()
	{
		return service.listAll();
	}
	@GetMapping("/jc/{input}")
	public ResponseEntity<List<String>> listjc(@PathVariable String input)
	{
		List<String> listj = service.listjc(input);
		return new ResponseEntity<List<String>>(listj,HttpStatus.OK);
	}
	
	@GetMapping("/{jobid}")
	public JobDetailsDomain getTask(@PathVariable long jobid)
	{
		return service.get(jobid);	
	}
	
	@PostMapping("/")
	public void addDetails(@RequestBody JobDetailsDomain jd)
	{
		service.save(jd);
	}
	
	@PutMapping(value="/{jobid}") 
	public ResponseEntity<?> editJobDetails(@RequestBody JobDetailsDomain newjobDetails, @PathVariable long jobid)
	{
		try 
		{
			JobDetailsDomain existingJobDetails=service.get(jobid);
			existingJobDetails.setJobtitle(newjobDetails.getJobtitle());
			existingJobDetails.setDomain(newjobDetails.getDomain());
			existingJobDetails.setRole(newjobDetails.getRole());
			
			existingJobDetails.setTechskills(newjobDetails.getTechskills());
			existingJobDetails.setExprange(newjobDetails.getExprange());
			existingJobDetails.setJobtype(newjobDetails.getJobtype());
			existingJobDetails.setJobdesc(newjobDetails.getJobdesc());
			existingJobDetails.setSalaryrange(newjobDetails.getSalaryrange());
			existingJobDetails.setOpenpositions(newjobDetails.getOpenpositions());
			existingJobDetails.setJoinedby(newjobDetails.getJoinedby());
			existingJobDetails.setCreatedby(newjobDetails.getCreatedby());
			existingJobDetails.setCreatedon(newjobDetails.getCreatedon());
			existingJobDetails.setAssignedon(newjobDetails.getAssignedon());
			existingJobDetails.setAssignedby(newjobDetails.getAssignedby());
			service.save(existingJobDetails);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{jobid}")
	public void delete(@PathVariable long jobid) 
	{
		service.delete(jobid);
	}
}
