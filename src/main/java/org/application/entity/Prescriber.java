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
@Table(name = "Prescriber")
public class Prescriber {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "npi", unique = true )
    private String npi;

    @Column(name = "firstName" )
    private String firstName;

    @Column(name = "lastName" )
    private String lastName;

    @Column(name = "title")
    private String title;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "patientRelation_id")
     @JsonBackReference
    private PatientRelations patientRelations;

    
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNpi() {
    return npi;
}

public void setNpi(String npi) {
    this.npi = npi;
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

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public PatientRelations getPatientRelations() {
    return patientRelations;
}

public void setPatientRelations(PatientRelations patientRelations) {
    this.patientRelations = patientRelations;
}

//declare void constructor
public Prescriber() {
}
}

