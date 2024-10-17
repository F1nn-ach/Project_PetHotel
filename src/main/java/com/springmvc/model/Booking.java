package com.springmvc.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name = "booking_id", length = 7, nullable = false)
	private String id;

	@Column(name = "booking_startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;

	@Column(name = "booking_enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;

	@Column(name = "booking_request", length = 150)
	private String request;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Calendar startDate, Calendar endDate, String request) {
		super();
		this.id = generateBookingId();
		this.startDate = startDate;
		this.endDate = endDate;
		this.request = request;
	}

	private String generateBookingId() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder bookingId = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			int index = random.nextInt(characters.length());
			bookingId.append(characters.charAt(index));
		}
		return bookingId.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
