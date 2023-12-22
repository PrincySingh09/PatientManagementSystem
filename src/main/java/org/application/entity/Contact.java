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
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="value" )
    private String value;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "PatientRelations_id")
     @JsonBackReference
    private PatientRelations patientRelations;


    //*  Getter and Setter methods for all fields

    // Getter and Setter for 'type'
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

    // Getter and Setter for 'value'
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Getter and Setter for 'patientRelations'
    public PatientRelations getPatientRelations() {
        return patientRelations;
    }

    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }

    //declare void constructor
    public Contact() {
    }
}
