package org.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import jakarta.persistence.FetchType;

@Entity
@Table(name = "ClinicalInfo")

public class ClinicalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "clinicalInfo", fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Allergies> allergies;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @OneToOne
    @JoinColumn(name = "patientRelation_id")
    @JsonBackReference
    private PatientRelations patientRelations;


    public List<Allergies> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergies> allergies) {
        this.allergies = allergies;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public PatientRelations getPatientRelations() {
        return patientRelations;
    }

    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }

    // declare void constructor
    public ClinicalInfo() {
    }



}

