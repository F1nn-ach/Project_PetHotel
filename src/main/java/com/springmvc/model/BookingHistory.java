package com.springmvc.model;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "booking_histories")
public class BookingHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private int historyId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_email")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@Column(name = "created_at")
    private Calendar createdAt;

	public BookingHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingHistory(int historyId, User user, Booking booking, Calendar createdAt) {
		super();
		this.historyId = historyId;
		this.user = user;
		this.booking = booking;
		this.createdAt = createdAt;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar calendar) {
		this.createdAt = calendar;
	}
}