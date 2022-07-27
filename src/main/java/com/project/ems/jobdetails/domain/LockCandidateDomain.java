package com.project.ems.jobdetails.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lockcandidate")
public class LockCandidateDomain {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long lock_id;

private long cno;

private long jobid;

public long getJobid() {
	return jobid;
}

public void setJobid(long jobid) {
	this.jobid = jobid;
}

public long getCno() {
	return cno;
}

public void setCno(long cno) {
	this.cno = cno;
}

private String lock_status;


private String lockedon;
private String lockedby;
private String lockreleasedon;
private String lockreleasedby;

public LockCandidateDomain() {
	super();
	// TODO Auto-generated constructor stub
}

public LockCandidateDomain(long lock_id, String lockedon, String lockedby, String lockreleasedon,
		String lockreleasedby, String lock_status) {
	super();
	this.lock_id = lock_id;
    this.lock_status=lock_status;
	this.lockedon = lockedon;
	this.lockedby = lockedby;
	this.lockreleasedon = lockreleasedon;
	this.lockreleasedby = lockreleasedby;
}

public long getLock_id() {
	return lock_id;
}

public void setLock_id(long lock_id) {
	this.lock_id = lock_id;
}



public String getLock_status() {
	return lock_status;
}

public void setLock_status(String lock_status) {
	this.lock_status = lock_status;
}

public String getLockedon() {
	return lockedon;
}

public void setLockedon(String lockedon) {
	this.lockedon = lockedon;
}

public String getLockedby() {
	return lockedby;
}

public void setLockedby(String lockedby) {
	this.lockedby = lockedby;
}

public String getLockreleasedon() {
	return lockreleasedon;
}

public void setLockreleasedon(String lockreleasedon) {
	this.lockreleasedon = lockreleasedon;
}

public String getLockreleasedby() {
	return lockreleasedby;
}

public void setLockreleasedby(String lockreleasedby) {
	this.lockreleasedby = lockreleasedby;
}

}
