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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pet_id", nullable = false)
	private long id;

	@Column(name = "pet_name", length = 50, nullable = false)
	private String name;

	@Column(name = "pet_gender", length = 10, nullable = false)
	private String gender;

	@Column(name = "pet_ageyear", nullable = false)
	private int ageYear;

	@Column(name = "pet_agemonth", nullable = false)
	private int ageMonth;

	@Column(name = "pet_breed", length = 100, nullable = false)
	private String breed;

	@Column(name = "pet_species", length = 100, nullable = false)
	private String species;

	@Column(name = "pet_weight")
	private double weight;

	@Column(name = "pet_request", length = 200)
	private String requests;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "pet_id")
//	private List<Booking> bookings = new ArrayList<>();

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String name, String gender, int ageYear, int ageMonth, String breed, String species,
			double weight, String requests) {
		super();
		this.name = name;
		this.gender = gender;
		this.ageYear = ageYear;
		this.ageMonth = ageMonth;
		this.breed = breed;
		this.species = species;
		this.weight = weight;
		this.requests = requests;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(List<Booking> bookings) {
//		this.bookings = bookings;
//	}

}
