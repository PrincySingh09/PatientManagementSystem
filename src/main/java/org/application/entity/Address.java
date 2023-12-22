package org.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Address")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column ( name = "type")
    private String type;

    @Column(name = "line1" )
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city" )
    private String city;

    @Column(name = "zip_code" )
    private String zip_code;

    @Column(name = "state_code" )
    private String state_code;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "PatientRelations_id")
     @JsonBackReference
    private PatientRelations patientRelations;

    //*  Getter and Setter methods for all fields


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }
    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getState_code() {
        return state_code;
    }
    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public PatientRelations getPatientRelations() {
        return patientRelations;
    }
    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }
    //constructor
    public Address() {}

}


