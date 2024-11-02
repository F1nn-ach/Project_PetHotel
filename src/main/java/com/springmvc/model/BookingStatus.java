package com.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "booking_statuses")
public class BookingStatus {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
	private int status_id;
	
	@Column(name = "status_name", nullable = false)
	private String statusName;

	public BookingStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingStatus(int status_id, String statusName) {
		super();
		this.status_id = status_id;
		this.statusName = statusName;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
