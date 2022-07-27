package com.project.ems.jobdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.ems.jobdetails.domain.CandidateDetailsDomain;
import com.project.ems.jobdetails.domain.FileDB;
import com.project.ems.jobdetails.domain.JobDetailsDomain;
import com.project.ems.jobdetails.domain.LockCandidateDomain;
import com.project.ems.jobdetails.repository.CandidateDetailsRepo;
import com.project.ems.jobdetails.repository.FileDBRepository;
import com.project.ems.jobdetails.repository.LockCandidateRepo;

@SuppressWarnings("unused")
@Service
public class CandidateDetailsService {
	@Autowired
	private CandidateDetailsRepo repo;
        
    @Autowired
	private FileDBRepository frepo;
    @Autowired
   	private LockCandidateRepo lrepo;
    
    
    

    
	
	public List<CandidateDetailsDomain> listAll()
	{
		return repo.findAll();
	}
	
	
	public boolean save(CandidateDetailsDomain candidatedetails) {
		
              List<FileDB> l = frepo.findAll();
		      FileDB fd = l.get(l.size()-1);
		      String fid = fd.getId();
		      if(fid!=null)
		      {
		         candidatedetails.setFid(fid);      
		      }
		      
		      CandidateDetailsDomain cd = repo.save(candidatedetails);
		     
		      if(candidatedetails.getStatus()!=null && cd!=null )
		    	  
		      {	  
		    	  LockCandidateDomain ld=new LockCandidateDomain();
		    	     
		    	     ld.setLock_status("y");
		    	     ld.setCno(cd.getCno());
		          
		             LockCandidateDomain lc = lrepo.save(ld);
		             cd.setLock_id(lc.getLock_id());
		             repo.save(cd);
		      
		      
		      
		      }
		      
		      if(cd!=null)
		      {
		    	  return true;
		      }
		      else
		      {
		    	  return false;
		      }
		      

               
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public CandidateDetailsDomain editCandidateDetails(long cno) {

		CandidateDetailsDomain existingCandidateDetails= repo.findById(cno).get();




		 return existingCandidateDetails;


	}
	
	
	public CandidateDetailsDomain get(long cno)
	{
		
		
		return repo.findById(cno).get();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public boolean delete(long cno)
	{
		repo.deleteById(cno);
		return repo.existsById(cno);
		
	}
}
