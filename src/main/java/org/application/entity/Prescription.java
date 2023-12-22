package org.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="NDC",  unique = true)
    private String NDC;

    @Column(name="rxNumber",  unique = true)
    private String rxNumber;

    @Column(name = "strength" )
    private String strength;

    @Column(name = "strength_units" )
    private int strength_units;

    @Column(name = "supply" )
    private int supply;

    @Column(name = "refills" )
    private int refills;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "patientRelations_id")
     @JsonBackReference
    private PatientRelations patientRelations;

    // Getter and Setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter methods for NDC
    public String getNDC() {
        return NDC;
    }

    public void setNDC(String NDC) {
        this.NDC = NDC;
    }

    // Getter and Setter methods for rxNumber
    public String getRxNumber() {
        return rxNumber;
    }

    public void setRxNumber(String rxNumber) {
        this.rxNumber = rxNumber;
    }

    // Getter and Setter methods for strength
    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    // Getter and Setter methods for strength_units
    public int getStrength_units() {
        return strength_units;
    }

    public void setStrength_units(int strength_units) {
        this.strength_units = strength_units;
    }

    // Getter and Setter methods for supply
    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    // Getter and Setter methods for refills
    public int getRefills() {
        return refills;
    }

    public void setRefills(int refills) {
        this.refills = refills;
    }

    // Getter and Setter methods for patientRelations
    public PatientRelations getPatientRelations() {
        return patientRelations;
    }

    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }

    //declare void constructor
    public Prescription() {
    }

}
