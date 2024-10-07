package com.springmvc.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
	@Id
	@Column(name = "owner_email", length = 100, nullable = false)
	private String email;

	@Column(name = "owner_phonenumber", length = 100, nullable = false)
	private String phoneNumber;

	@Column(name = "owner_firstname", length = 100, nullable = false)
	private String firstname;

	@Column(name = "owner_lastname", length = 100, nullable = false)
	private String lastname;

	@Column(name = "owner_username", length = 100, nullable = false)
	private String username;

	@Column(name = "owner_password", length = 100, nullable = false)
	private String password;

	@Column(name = "owner_url", length = 300, nullable = false)
	private String pic_url;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_email")
	private List<Pet> pets = new ArrayList<Pet>();

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}


}
