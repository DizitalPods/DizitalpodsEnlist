package com.project.ems.jobdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.repository.LockCandidateRepo;

@Service
public class LockCandidateService {
@Autowired
private LockCandidateRepo repo;

public List<LockCandidateDomain> listAll()
{
	return repo.findAll();
}

public void save(LockCandidateDomain lockcandidatedetails)
{
	repo.save(lockcandidatedetails);
}
	
	public LockCandidateDomain get(long lock_id)
	{
		return repo.findById(lock_id).get();
	}
	
	public void delete(long lock_id)
	{
		repo.deleteById(lock_id);
	}
	
}
