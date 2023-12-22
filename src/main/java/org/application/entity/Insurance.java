package org.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="bin" )
    private String bin;

    @Column(name= "firstName" )
    private String firstName;

    @Column(name= "lastName" )
    private String lastName;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "patientRelation_id")
    @JsonBackReference
    private PatientRelations patientRelations;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PatientRelations getPatientRelations() {
        return patientRelations;
    }

    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }

    //declare void constructor
    public Insurance() {
    }



}
