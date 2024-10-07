package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "address", length = 200, nullable = false)
	private String address;
	
	@Column(name = "contactN]number", length = 10, nullable = false)
	private String contactNumber;
}
