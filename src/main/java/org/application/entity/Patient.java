package org.application.entity;

import jakarta.persistence.*;

//import local date
import java.time.LocalDate;
//import date formator
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName" )
    private String firstName;

    @Column(name = "lastName" )
    private String lastName;

    @Column(name="dateOfBirth" )
    private LocalDate dateOfBirth;

    @Column(name="gender" )
    private String gender ;

    @OneToOne( mappedBy = "patient", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "PatientRelations_id", referencedColumnName = "id")
    private PatientRelations patientRelations;

    //constructor
    public Patient() {}

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String gender, PatientRelations patientRelations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.patientRelations = patientRelations;
    }

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        //convert date to time format dd-mm-yyyy    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = dateOfBirth.format(formatter);
        this.dateOfBirth = LocalDate.parse(date, formatter);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PatientRelations getPatientRelations() {
        return patientRelations;
    }

    public void setPatientRelations(PatientRelations patientRelations) {
        this.patientRelations = patientRelations;
    }


    //declare void constructor


}
