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

import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.service.LockCandidateService;

@RestController
public class LockCandidateController {
@Autowired
private LockCandidateService service;

@GetMapping("/lockcandidate")
public List<LockCandidateDomain> listAll()
{
	return service.listAll();
}

@GetMapping("/lockcandidate/{lock_id}")
public LockCandidateDomain getTask(@PathVariable long lock_id)
{
	return service.get(lock_id);
}

@PostMapping("/lockcandidate")
public void addDetails(@RequestBody LockCandidateDomain lcd)
{
	service.save(lcd);
}

@PutMapping(value="/lockcandidate/{lock_id}")
public ResponseEntity<?> editCandidateDetails(@RequestBody LockCandidateDomain newLockCandidateDetails, @PathVariable long lock_id)
{
	try {
		LockCandidateDomain existingCandidateDetails = service.get(lock_id);
		
		existingCandidateDetails.setLockedon(newLockCandidateDetails.getLockedon());
		existingCandidateDetails.setLockedby(newLockCandidateDetails.getLockedby());
		existingCandidateDetails.setLockreleasedon(newLockCandidateDetails.getLockreleasedon());
		existingCandidateDetails.setLockreleasedby(newLockCandidateDetails.getLockreleasedby());
		
		service.save(existingCandidateDetails);
		return new ResponseEntity<>(HttpStatus.OK);
		}
	catch (Exception e)
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/lockcandidate/{lock_id}")
public void delete(@PathVariable long lock_id) 
{
	service.delete(lock_id);
}
}
