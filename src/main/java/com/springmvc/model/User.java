package com.springmvc.model;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="users")
public class User {
	@Id
	private String email;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="password", length=100, nullable=false)
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date birtday;
	
	@Column(name="pic_url", length=300, nullable=false)
	private String pic_url;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String name, String password, Date birtday, String pic_url) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.birtday = birtday;
		this.pic_url = pic_url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirtday() {
		return birtday;
	}

	public void setBirtday(Date birtday) {
		this.birtday = birtday;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	
	
}
