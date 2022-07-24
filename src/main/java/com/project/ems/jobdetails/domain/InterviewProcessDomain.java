package com.project.ems.jobdetails.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interviewprocess")
public class InterviewProcessDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long interviewid;
	private long lock_id;
	private String stage1;
	private String stage2;
	private String stage3;
	private String i_status;
	public InterviewProcessDomain() {
		super();
	}
	public InterviewProcessDomain(long interviewid, long lock_id, String stage1, String stage2, String stage3,
			String i_status) {
		super();
		this.interviewid = interviewid;
		this.lock_id = lock_id;
		this.stage1 = stage1;
		this.stage2 = stage2;
		this.stage3 = stage3;
		this.i_status = i_status;
	}
	public long getInterviewid() {
		return interviewid;
	}
	public void setInterviewid(long interviewid) {
		this.interviewid = interviewid;
	}
	public long getLock_id() {
		return lock_id;
	}
	public void setLock_id(long lock_id) {
		this.lock_id = lock_id;
	}
	public String getStage1() {
		return stage1;
	}
	public void setStage1(String stage1) {
		this.stage1 = stage1;
	}
	public String getStage2() {
		return stage2;
	}
	public void setStage2(String stage2) {
		this.stage2 = stage2;
	}
	public String getStage3() {
		return stage3;
	}
	public void setStage3(String stage3) {
		this.stage3 = stage3;
	}
	public String getI_status() {
		return i_status;
	}
	public void setI_status(String i_status) {
		this.i_status = i_status;
	}
	
	
	
}
