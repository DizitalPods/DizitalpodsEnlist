package com.project.ems.jobdetails.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobdetails")
public class JobDetailsDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobid;
	private String jobtitle;
	private String domain;
	private String  workremotely;
	private String role;
	private String client;
	private String techskills;
	private String exprange;
	private String jobtype;
	private String jobdesc;
	private String salaryrange;
	private String openpositions;
	private String joinedby;
	private String createdby;
	private String createdon;
	private String assignedon;
	private String assignedby;
	
	private String roledisplay;
	
	

	

	

	
	
	public JobDetailsDomain() 
	{
		super();
	}
	
	public JobDetailsDomain(long jobid, String jobtitle, String domain, String role, String techskills,
			String exprange, String jobtype, String jobdesc, String salaryrange, String openpositions, String joinedby,
			String createdby,String  workremotely, String createdon, String assignedon, String assignedby) {
		super();
		this.jobid = jobid;
		this.jobtitle = jobtitle;
		this.domain = domain;
		this.role = role;
		this.workremotely=  workremotely;
		this.techskills = techskills;
		this.exprange = exprange;
		this.jobtype = jobtype;
		this.jobdesc = jobdesc;
		this.salaryrange = salaryrange;
		this.openpositions = openpositions;
		this.joinedby = joinedby;
		this.createdby = createdby;
		this.createdon = createdon;
		this.assignedon = assignedon;
		this.assignedby = assignedby;
	}
	public String getRoledisplay() {
		return roledisplay;
	}

	public void setRoledisplay(String roledisplay) {
		this.roledisplay = roledisplay;
	}

	public String getWorkremotely() {
		return workremotely;
	}

	public void setWorkremotely(String workremotely) {
		this.workremotely = workremotely;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public long getJobid() {
		return jobid;
	}
	public void setJobid(long jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getTechskills() {
		return techskills;
	}
	public void setTechskills(String techskills) {
		this.techskills = techskills;
	}
	public String getExprange() {
		return exprange;
	}
	public void setExprange(String exprange) {
		this.exprange = exprange;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	public String getSalaryrange() {
		return salaryrange;
	}
	public void setSalaryrange(String salaryrange) {
		this.salaryrange = salaryrange;
	}
	public String getOpenpositions() {
		return openpositions;
	}
	public void setOpenpositions(String openpositions) {
		this.openpositions = openpositions;
	}
	public String getJoinedby() {
		return joinedby;
	}
	public void setJoinedby(String joinedby) {
		this.joinedby = joinedby;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	
	public String getAssignedon() {
		return assignedon;
	}
	public void setAssignedon(String assignedon) {
		this.assignedon = assignedon;
	}
	public String getAssignedby() {
		return assignedby;
	}
	public void setAssignedby(String assignedby) {
		this.assignedby = assignedby;
	}

	@Override
	public String toString() {
		return "JobDetailsDomain [jobid=" + jobid + ", jobtitle=" + jobtitle + ", domain=" + domain + ", role=" + role
				+ ", client=" + client + ", techskill=" + techskills + ", exprange=" + exprange + ", jobtype=" + jobtype
				+ ", jobdesc=" + jobdesc + ", salaryrange=" + salaryrange + ", openposition=" + openpositions
				+ ", joinedby=" + joinedby + ", createdby=" + createdby + ", createdon=" + createdon + ", assignedon="
				+ assignedon + ", assignedby=" + assignedby + "]";
	}
	
	
}
