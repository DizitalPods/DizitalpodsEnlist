package com.project.ems.jobdetails.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class ClientsDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clno;
	private String cname;
	private String principlecontact;
	private String mail;
	private String address;
	private String location;
	public long getClno() {
		return clno;
	}
	public void setClno(long clno) {
		this.clno = clno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPrinciplecontact() {
		return principlecontact;
	}
	public void setPrinciplecontact(String principlecontact) {
		this.principlecontact = principlecontact;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ClientsDomain(long clno, String cname, String principlecontact, String mail, String address,
			String location) {
		super();
		this.clno = clno;
		this.cname = cname;
		this.principlecontact = principlecontact;
		this.mail = mail;
		this.address = address;
		this.location = location;
	}
	
	

}
