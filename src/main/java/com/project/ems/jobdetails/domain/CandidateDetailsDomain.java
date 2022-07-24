package com.project.ems.jobdetails.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class CandidateDetailsDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cno;
	private String fname;
	private String lname;
	private String pno;
    private String role;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String email;
	private String techskills;
	
	private String totalexp;
	
	private String linkedinid;
	

	private String createdon;
	private String createdby;
	private String updatedon;
	private String updatedby;
	private String fid;
	private long lock_id;
	private long clno;
	public long getClno() {
		return clno;
	}

	public void setClno(long clno) {
		this.clno = clno;
	}

	public long getLock_id() {
		return lock_id;
	}

	public void setLock_id(long lock_id)
	{
		this.lock_id = lock_id;
	}

	
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public CandidateDetailsDomain() {
		super();
		
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CandidateDetailsDomain(long cno, String fname, String lname, String pno, String email,
			String techskills,  String totalexp,
			String linkedinid,  String createdon, String createdby, String updatedon, String updatedby,
			String role) {
		super();
		this.cno = cno;
		this.fname = fname;
		this.lname = lname;
		this.pno = pno;
		
		this.email = email;
		this.techskills = techskills;
		
		this.totalexp = totalexp;
		
		
		this.linkedinid = linkedinid;
		
		this.createdon = createdon;
		this.createdby = createdby;
		this.updatedon = updatedon;
		this.updatedby = updatedby;
		
		this.role=role;
	}

	public long getCno() {
		return cno;
	}

	public void setCno(long cno) {
		this.cno = cno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTechskills() {
		return techskills;
	}

	public void setTechskills(String techskills) {
		this.techskills = techskills;
	}

	

	public String getTotalexp() {
		return totalexp;
	}

	public void setTotalexp(String totalexp) {
		this.totalexp = totalexp;
	}

	

	

	public String getLinkedinid() {
		return linkedinid;
	}

	public void setLinkedinid(String linkedinid) {
		this.linkedinid = linkedinid;
	}

	

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	

	
	
	
	
}
