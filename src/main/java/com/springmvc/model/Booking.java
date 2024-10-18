package com.springmvc.model;

import java.text.SimpleDateFormat;
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
	@Column(name = "booking_id", length = 13, nullable = false)
	private String id;

	@Column(name = "booking_startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startDate;

	@Column(name = "booking_enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endDate;

	@Column(name = "booking_request", length = 150)
	private String request;

	@Column(name = "booking_status", length = 30, nullable = false)
	private String status;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Calendar startDate, Calendar endDate, String request, String status) {
		super();
		this.id = generateBookingId();
		this.startDate = startDate;
		this.endDate = endDate;
		this.request = request;
		this.status = status;
	}

	public String generateBookingId() {
		HotelManager hm = new HotelManager();
		long totalBookings = hm.getTotalBookingId();
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		int maxNumber = 999;
		int numberPart = (int) ((totalBookings % maxNumber) + 1);
		char letterPart = (char) ('A' + (totalBookings / maxNumber));
		String newId = String.format("B%s%03d%c", date, numberPart, letterPart);

		return newId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isOverlapping(Calendar start1, Calendar end1, Calendar start2, Calendar end2) {
		long buffer = 60 * 60 * 1000;
		return start1.getTimeInMillis() < end2.getTimeInMillis() + buffer
				&& start2.getTimeInMillis() < end1.getTimeInMillis() + buffer;
	}

}
