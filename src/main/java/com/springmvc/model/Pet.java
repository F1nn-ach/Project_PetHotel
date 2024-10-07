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
	private int id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "type", length = 100, nullable = false)
	private String type;
	
	@Column(name = "gender", length = 10, nullable = false)
	private String gender;
	
	@Column(name = "request", length = 200, nullable = false)
	private String request;
}
