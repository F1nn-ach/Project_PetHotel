package com.springmvc.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@Column(name = "booking_id", length = 7, nullable = false)
	private String id;

	@Column(name = "booking_startdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;

	@Column(name = "booking_enddate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Calendar startDate, Calendar endDate) {
		super();
		this.id = generateBookingId();
		this.startDate = startDate;
		this.endDate = endDate;
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

}
