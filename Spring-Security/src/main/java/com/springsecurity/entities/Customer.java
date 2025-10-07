package com.springsecurity.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer cid;
	private String name;
	private String email;
	private String pwd;
	private String pno;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public Customer(Integer cid, String name, String email, String pwd, String pno) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.pno = pno;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
