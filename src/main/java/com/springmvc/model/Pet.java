package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pet_id", nullable = false)
	private long id;

	@Column(name = "pet_name", length = 50, nullable = false)
	private String name;

	@Column(name = "pet_ageyear", nullable = false)
	private int ageYear;

	@Column(name = "pet_agemonth", nullable = false)
	private int ageMonth;

	@Column(name = "pet_type", length = 100, nullable = false)
	private String pet_type;

	@Column(name = "pet_gender", length = 10, nullable = false)
	private String gender;

	@Column(name = "pet_request", length = 200)
	private String request;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String name, int ageYear, int ageMonth, String pet_type, String gender, String request) {
		super();
		this.name = name;
		this.ageYear = ageYear;
		this.ageMonth = ageMonth;
		this.pet_type = pet_type;
		this.gender = gender;
		this.request = request;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgeYear() {
		return ageYear;
	}

	public void setAgeYear(int ageYear) {
		this.ageYear = ageYear;
	}

	public int getAgeMonth() {
		return ageMonth;
	}

	public void setAgeMonth(int ageMonth) {
		this.ageMonth = ageMonth;
	}

	public String getPet_type() {
		return pet_type;
	}

	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
