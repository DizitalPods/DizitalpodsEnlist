package com.project.ems.jobdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.jobdetails.domain.InterviewProcessDomain;
import com.project.ems.jobdetails.repository.InterviewProcessRepo;

@Service
public class InterviewProcessService {
	@Autowired
	private InterviewProcessRepo repo;
	
	public List<InterviewProcessDomain> listAll()
	{
		return repo.findAll();
	}
	public void save(InterviewProcessDomain interviewprocess)
	{
		repo.save(interviewprocess);
	}
	public InterviewProcessDomain get(long interviewid)
	{
		return repo.findById(interviewid).get();
	}
	public void delete (long interviewid)
	{
		repo.deleteById(interviewid);
	}
}
