package com.springmvc.model;

import javax.persistence.*;
import com.springmvc.manager.BookingManager;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "booking_startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    @Column(name = "booking_enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;

    @Column(name = "booking_request", length = 150)
    private String request;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;  

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PetActivity> petActivities = new ArrayList<>();

    public Booking() {
        super();
    }

    public Booking(Calendar startDate, Calendar endDate, String request, BookingStatus status, Room room,
                   Pet pet, List<PetActivity> petActivities) {
        this.bookingId = generateBookingId();
        this.startDate = startDate;
        this.endDate = endDate;
        this.request = request;
        this.status = status;
        this.room = room;
        this.pet = pet;  
        this.petActivities = petActivities;
    }
    
	public String generateBookingId() {
        BookingManager bm = new BookingManager();
        long totalBookings = bm.getTotalBookingId();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int maxNumber = 999;
        int numberPart = (int) ((totalBookings % maxNumber) + 1);
        char letterPart = (char) ('A' + (totalBookings / maxNumber));
        return String.format("B%s%03d%c", date, numberPart, letterPart);
    }

	public boolean isOverlapping(Calendar start1, Calendar end1, Calendar start2, Calendar end2) {
		long buffer = 60 * 60 * 1000; 
		return start1.getTimeInMillis() < end2.getTimeInMillis() + buffer
				&& start2.getTimeInMillis() < end1.getTimeInMillis() + buffer;
	}

	public double calculateDurationInDaysAndHours(Calendar startDateTime, Calendar endDateTime) {
		long startMillis = startDateTime.getTimeInMillis();
		long endMillis = endDateTime.getTimeInMillis();
		long durationInMillis = endMillis - startMillis;
		double durationInHours = (double) durationInMillis / (1000 * 60 * 60);
		int days = (int) durationInHours / 24;
		double remainingHours = durationInHours % 24;
		return days + (remainingHours / 24);
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId() {
		this.bookingId = generateBookingId();
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

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<PetActivity> getPetActivities() {
		return petActivities;
	}

	public void setPetActivities(List<PetActivity> petActivities) {
		this.petActivities = petActivities;
	}
}