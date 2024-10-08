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

	@Column(name = "owner_phonenumber", length = 10, nullable = false)
	private String phoneNumber;

	@Column(name = "owner_firstname", length = 50, nullable = false)
	private String firstname;

	@Column(name = "owner_lastname", length = 50, nullable = false)
	private String lastname;

	@Column(name = "owner_username", length = 50, nullable = false)
	private String username;

	@Column(name = "owner_password", length = 100, nullable = false)
	private String password;

	@Column(name = "owner_url", length = 200, nullable = false)
	private String pic_url;

	@Column(name = "owner_role", length = 15, nullable = false)
	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_email")
	private List<Pet> pets = new ArrayList<Pet>();

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(String email, String phoneNumber, String firstname, String lastname, String username, String password,
			String pic_url) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.pic_url = pic_url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
