package com.springmvc.model;

import java.util.*;
import javax.persistence.*;
import com.springmvc.manager.PetManager;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @Column(name = "pet_id")
    private String petId;

    @Column(name = "pet_name", length = 50, nullable = false)
    private String petName;

    @Column(name = "pet_gender", length = 50, nullable = false)
    private String petGender;

    @Column(name = "pet_age", length = 50, nullable = false)
    private String petAge;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_type_id", nullable = false) 
    private PetType petType;

    @Column(name = "pet_breed", length = 100, nullable = false)
    private String petBreed;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", nullable = false)
    private User user;

    public Pet() {
        super();
    }
    public Pet(String petName, String petGender, String petAge, PetType petType, String petBreed,
			User user) {
		super();
		this.petName = petName;
		this.petGender = petGender;
		this.petAge = petAge;
		this.petType = petType;
		this.petBreed = petBreed;
		this.user = user;
	}

	public String generatePetId() {
        PetManager pm = new PetManager();
        long totalPets = pm.getTotalPetId();
        int maxNumber = 9999;
        int numberPart = (int) ((totalPets % maxNumber) + 1);
        char letterPart = (char) ('A' + (totalPets / maxNumber));
        return String.format("P%04d%c", numberPart, letterPart);
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId() {
        this.petId = generatePetId();
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public PetType getPetType() {
        return petType; 
    }

    public void setPetType(PetType petType) {
        this.petType = petType; 
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
