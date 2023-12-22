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
@Table(name = "Allergies")
public class Allergies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category" )
    private String category;

    @Column(name = "clinical_status" )
    private String clinical_status;

    @Column(name = "severity" )
    private String severity;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "ClinicalInfo_id")
     @JsonBackReference
    private ClinicalInfo clinicalInfo;

public Long getId() {
    return id;
}
 public void setId(Long id) {
     this.id = id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClinical_status() {
        return clinical_status;
    }

    public void setClinical_status(String clinical_status) {
        this.clinical_status = clinical_status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public ClinicalInfo getClinicalInfo() {
        return clinicalInfo;
    }

    public void setClinicalInfo(ClinicalInfo clinicalInfo) {
        this.clinicalInfo = clinicalInfo;
    }

    //constructor
    public Allergies (){}
}

