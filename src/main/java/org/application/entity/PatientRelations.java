package org.application.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.CascadeType;

@Entity
@Table(name = "PatientRelations")
public class PatientRelations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //one to one relationship with patient
    //required
    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
     @JsonBackReference
    private Patient patient;
    //relation to Clinical info one to one
    
    @OneToOne(mappedBy = "patientRelations", cascade = CascadeType.ALL , fetch =FetchType.LAZY)
    @JsonManagedReference
    private ClinicalInfo clinicalInfo;

    @OneToOne(mappedBy = "patientRelations", cascade = CascadeType.ALL , fetch =FetchType.LAZY)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id")
    @JsonManagedReference
    private Insurance insurance;

    //relation to prescriber one to one
    @OneToOne(mappedBy = "patientRelations", cascade = CascadeType.ALL , fetch =FetchType.LAZY)
    @JoinColumn(name = "prescriber_id", referencedColumnName = "id")
    @JsonManagedReference
    private Prescriber prescriber;

    //relation to contact one to many
    @OneToMany(mappedBy = "patientRelations", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @JsonManagedReference
    private List<Contact> contacts = new ArrayList<>();

    //relation to allergies one to many
    @OneToMany(mappedBy = "patientRelations", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @JsonManagedReference
    private List<Prescription> prescription = new ArrayList<>();

    @OneToMany (mappedBy = "patientRelations", cascade = CascadeType.ALL , fetch =FetchType.LAZY)
    @JsonManagedReference
    private List<Address> address = new ArrayList<>();

    //constructor
    public PatientRelations() {}

  //getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ClinicalInfo getClinicalInfo() {
        return clinicalInfo;
    }

    public void setClinicalInfo(ClinicalInfo clinicalInfo) {
        this.clinicalInfo = clinicalInfo;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Prescriber getPrescriber() {
        return prescriber;
    }

    public void setPrescriber(Prescriber prescriber) {
        this.prescriber = prescriber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Prescription> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<Prescription> prescription) {
        this.prescription = prescription;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
