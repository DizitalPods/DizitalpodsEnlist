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
    
    @Autowired
    private  JobDetailsDomain js;

	
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
		     
		      if(js.getRoledisplay().equals("y")&& cd!=null)
		      {	  
		    	  LockCandidateDomain ld=new LockCandidateDomain();
		    	     
		    	     ld.setLock_status("y");
		    	     ld.setCno(cd.getCno());
		          
		          lrepo.save(ld);
		      
		      
		      
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
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean editCandidateDetails(CandidateDetailsDomain newCandidateDetails,long cno) {

		CandidateDetailsDomain existingCandidateDetails= repo.findById(cno).get();




		 if(existingCandidateDetails!=null)
		{
			
			existingCandidateDetails.setFname(newCandidateDetails.getFname());
			existingCandidateDetails.setLname(newCandidateDetails.getLname());
			existingCandidateDetails.setPno(newCandidateDetails.getPno());
			
			existingCandidateDetails.setEmail(newCandidateDetails.getEmail());
			existingCandidateDetails.setTechskills(newCandidateDetails.getTechskills());
			
			existingCandidateDetails.setTotalexp(newCandidateDetails.getTotalexp());
			
			
			
			existingCandidateDetails.setLinkedinid(newCandidateDetails.getLinkedinid());
			
			existingCandidateDetails.setCreatedon(newCandidateDetails.getCreatedon());
			existingCandidateDetails.setCreatedby(newCandidateDetails.getCreatedby());
			existingCandidateDetails.setUpdatedon(newCandidateDetails.getUpdatedon());
			existingCandidateDetails.setUpdatedby(newCandidateDetails.getUpdatedby());
			
		       repo.save(existingCandidateDetails);
			return true;
		} 
		else
		{
			return false;
		}


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
