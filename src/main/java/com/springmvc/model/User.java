package com.springmvc.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_firstname", length = 100, nullable = false)
	private String userFirstname;

	@Column(name = "user_lastname", length = 100, nullable = false)
	private String userLastname;

	@Column(name = "user_phone", length = 10, nullable = false, unique = true)
	private String userPhone;

	@Column(name = "user_password", nullable = false)
	private String userPassword;

	@Column(name = "is_admin", columnDefinition = "TINYINT(1)")
	private boolean isAdmin;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pet> userPets = new ArrayList<>();

	public User() {
		super();
	}

	public User(String userEmail, String userFirstname, String userLastname, String userPhone, String userPassword,
			boolean isAdmin, List<Pet> userPets) {
		this.userEmail = userEmail;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.isAdmin = isAdmin;
		this.userPets = userPets;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Pet> getUserPets() {
		return userPets;
	}

	public void setUserPets(List<Pet> userPets) {
		this.userPets = userPets;
	}
}