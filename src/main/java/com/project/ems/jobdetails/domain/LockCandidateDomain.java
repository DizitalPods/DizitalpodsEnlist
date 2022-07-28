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
private String lockedon;
private String lockedby;
private String lockreleasedon;
private String lockreleasedby;

public LockCandidateDomain() {
	
	super();
	
}

public LockCandidateDomain(long lock_id, long cno,long jobid,String lockedon, String lockedby, String lockreleasedon,
		String lockreleasedby) {
	super();
	this.lock_id = lock_id;
    this.cno=cno;
    this.jobid=jobid;
	this.lockedon = lockedon;
	this.lockedby = lockedby;
	this.lockreleasedon = lockreleasedon;
	this.lockreleasedby = lockreleasedby;
}

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








public long getLock_id() {
	return lock_id;
}

public void setLock_id(long lock_id) {
	this.lock_id = lock_id;
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
