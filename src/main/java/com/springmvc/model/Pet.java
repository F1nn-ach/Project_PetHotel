package com.springmvc.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@Column(name = "pet_id", length = 6, nullable = false)
	private String id;

	@Column(name = "pet_name", length = 50, nullable = false)
	private String name;

	@Column(name = "pet_gender", length = 10, nullable = false)
	private String gender;

	@Column(name = "pet_age", length = 20, nullable = false)
	private String age;

	@Column(name = "pet_breed", length = 100, nullable = false)
	private String breed;

	@Column(name = "pet_species", length = 100)
	private String species;

	@Column(name = "pet_request", length = 200)
	private String requests;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pet_id")
	private List<Booking> bookings = new ArrayList<>();

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String name, String gender, String age, String breed, String species, String requests) {
		super();
		this.id = generateId();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.breed = breed;
		this.species = species;
		this.requests = requests;
	}

	private String generateId() {
		String randomPart = UUID.randomUUID().toString().replace("-", "").substring(0, 4);
		return "H0" + randomPart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}
