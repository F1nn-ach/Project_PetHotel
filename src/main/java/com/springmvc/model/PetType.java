package com.springmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "pet_types")
public class PetType {
    @Id
    @Column(name = "pet_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petTypeId;

    @Column(name = "pet_type_name", nullable = false)
    private String petTypeName;

    @Column(name = "pet_care_price", nullable = false)
    private double petCarePrice;

    public PetType() {
        super();
    }

    public PetType(int petTypeId, String petTypeName, double petCarePrice) {
        super();
        this.petTypeId = petTypeId;
        this.petTypeName = petTypeName;
        this.petCarePrice = petCarePrice;
    }

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    public double getPetCarePrice() {
        return petCarePrice;
    }

    public void setPetCarePrice(double petCarePrice) {
        this.petCarePrice = petCarePrice;
    }
}
