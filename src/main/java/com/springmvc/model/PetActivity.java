package com.springmvc.model;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pet_activities")
public class PetActivity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private int activityId;

    @Column(name = "activity_detail", length = 255, nullable = false)
    private String activityDetail;

    @Column(name = "activity_image", nullable = false)
    private String activityImage;

    @Column(name = "activity_date", nullable = false)
    private LocalDate activityDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

	public PetActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetActivity(int activityId, String activityDetail, String activityImage, LocalDate activityDate, Pet pet,
			Booking booking) {
		super();
		this.activityId = activityId;
		this.activityDetail = activityDetail;
		this.activityImage = activityImage;
		this.activityDate = activityDate;
		this.pet = pet;
		this.booking = booking;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityDetail() {
		return activityDetail;
	}

	public void setActivityDetail(String activityDetail) {
		this.activityDetail = activityDetail;
	}

	public String getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(String activityImage) {
		this.activityImage = activityImage;
	}

	public LocalDate getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(LocalDate activityDate) {
		this.activityDate = activityDate;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
