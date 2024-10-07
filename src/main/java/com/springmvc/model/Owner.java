package com.springmvc.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Owner {
	@Id
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "phonenumber", length = 100, nullable = false)
	private String phoneNumber;

	@Column(name = "firstname", length = 100, nullable = false)
	private String firstname;

	@Column(name = "lastname", length = 100, nullable = false)
	private String lastname;

	@Column(name = "username", length = 100, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "pic_url", length = 300, nullable = false)
	private String pic_url;

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}


}
