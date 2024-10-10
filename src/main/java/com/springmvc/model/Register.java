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
@Table(name = "register")
public class Register {
	@Id
	@Column(name = "register_email", length = 55, nullable = false)
	private String email;

	@Column(name = "register_phonenumber", length = 10, nullable = false)
	private String phoneNumber;

	@Column(name = "register_firstname", length = 50, nullable = false)
	private String firstname;

	@Column(name = "register_lastname", length = 50, nullable = false)
	private String lastname;

	@Column(name = "register_password", length = 55, nullable = false)
	private String password;

	@Column(name = "register_role", length = 15)
	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "register_email")
	private List<Pet> pets = new ArrayList<>();

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String email, String phoneNumber, String firstname, String lastname, String password) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
