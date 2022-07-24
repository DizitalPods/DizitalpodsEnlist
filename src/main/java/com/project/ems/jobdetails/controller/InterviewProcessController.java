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

import com.project.ems.jobdetails.domain.InterviewProcessDomain;
import com.project.ems.jobdetails.service.InterviewProcessService;

@RestController
public class InterviewProcessController {
@Autowired
private InterviewProcessService service;

@GetMapping("/interviewprocess")
public List<InterviewProcessDomain> listAll()
{
	return service.listAll();
}

@GetMapping("/interviewprocess/{interviewid}")
public InterviewProcessDomain getTask(@PathVariable long interviewid)
{
	return service.get(interviewid);
}

@PostMapping("/interviewprocess")
public void addDetails(@RequestBody InterviewProcessDomain ipd)
{
	service.save(ipd);
}

@PutMapping (value="/interviewprocess/{interviewid}")
public ResponseEntity<?> editInterviewDetails (@RequestBody InterviewProcessDomain newInterviewProcessDetails, @PathVariable long interviewid)
{
	try
	{
		InterviewProcessDomain existingInterviewDetails=service.get(interviewid);
		existingInterviewDetails.setLock_id(newInterviewProcessDetails.getLock_id());
		existingInterviewDetails.setStage1(newInterviewProcessDetails.getStage1());
		existingInterviewDetails.setStage2(newInterviewProcessDetails.getStage2());
		existingInterviewDetails.setStage3(newInterviewProcessDetails.getStage3());
		existingInterviewDetails.setI_status(newInterviewProcessDetails.getI_status());
		
		service.save(existingInterviewDetails);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (Exception e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}


@DeleteMapping("/interviewprocess/{interviewid}")
public void delete(@PathVariable long interviewid)
{
	service.delete(interviewid);
}
}
