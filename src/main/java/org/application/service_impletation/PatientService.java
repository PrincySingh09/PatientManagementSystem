package org.application.service_impletation;

import org.application.entity.*;
import org.application.repository.*;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ClinicalInfoRepository clinicalInfoRepository;

    @Autowired
    private AllergiesRepository allergiesRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Patient savePatientWithRelations(Patient patientWithRelations) {

        //* get the data */
        PatientRelations patientRelations = patientWithRelations.getPatientRelations();
        ClinicalInfo clinicalInfo = patientRelations.getClinicalInfo();
        List<Allergies> allergies = clinicalInfo.getAllergies();
        Insurance insurance = patientRelations.getInsurance();
        List<Contact> contacts = patientRelations.getContacts();
        List<Prescription> prescriptions = patientRelations.getPrescription();
        List<Address> addresses = patientRelations.getAddress();

        //*save the patient  */
        Patient savedPatient = patientRepository.save(patientWithRelations);

        //& setting parent relation inside related entities 
        clinicalInfo.setPatientRelations(patientRelations);
        ClinicalInfo savedClinicalInfo = clinicalInfoRepository.save(clinicalInfo);
        
        for (Allergies allergy : allergies) {
            allergy.setClinicalInfo(savedClinicalInfo);
            allergiesRepository.save(allergy);
        }

        insurance.setPatientRelations(patientRelations);
        insuranceRepository.save(insurance);

        contacts.forEach(contact -> contact.setPatientRelations(patientRelations));
        contacts.forEach(contact -> contactRepository.save(contact));

        prescriptions.forEach(prescription -> prescription.setPatientRelations(patientRelations));
        prescriptions.forEach(prescription -> prescriptionRepository.save(prescription));

        addresses.forEach(address -> address.setPatientRelations(patientRelations));
        addresses.forEach(address -> addressRepository.save(address));


        //&setting child relation inside parent entity

        patientRelations.setClinicalInfo(savedClinicalInfo);
        patientRelations.setInsurance(insurance);
        patientRelations.setContacts(contacts);
        patientRelations.setPrescription(prescriptions);
        patientRelations.setAddress(addresses);
        patientRelations.setPatient(savedPatient);
        savedPatient.setPatientRelations(patientRelations);
        patientRepository.save(savedPatient);


        //^ save related entities

        return savedPatient;
    }


    public Patient updatePatientWithRelations(Patient updatedPatientWithRelations) {
        // Get the existing patient from the repository
        Patient existingPatient = patientRepository.findById(updatedPatientWithRelations.getId())
                .orElseThrow(() -> new NoSuchElementException("Patient not found"));
    
        // Update the properties of the existing patient entity with the updated data
        existingPatient.setFirstName(updatedPatientWithRelations.getFirstName());
        existingPatient.setLastName(updatedPatientWithRelations.getLastName());
        existingPatient.setDateOfBirth(updatedPatientWithRelations.getDateOfBirth());
        existingPatient.setGender(updatedPatientWithRelations.getGender());
    
        // Update relationships: ClinicalInfo
        ClinicalInfo updatedClinicalInfo = updatedPatientWithRelations.getPatientRelations().getClinicalInfo();
        ClinicalInfo existingClinicalInfo = existingPatient.getPatientRelations().getClinicalInfo();
        existingClinicalInfo.setHeight(updatedClinicalInfo.getHeight());
        existingClinicalInfo.setWeight(updatedClinicalInfo.getWeight());
    
        // Update relationships: Allergies
        List<Allergies> updatedAllergies = updatedClinicalInfo.getAllergies();
        List<Allergies> existingAllergies = existingClinicalInfo.getAllergies();
        existingAllergies.addAll(updatedAllergies);
        // allergiesRepository.deleteAll(existingAllergies);
        //for each allergy in the list of allergies, set the clinical info to the existing clinical info
        existingAllergies.forEach(allergy -> allergy.setClinicalInfo(existingClinicalInfo));
        existingClinicalInfo.setAllergies(existingAllergies);

        //save the updated clinical info
        clinicalInfoRepository.save(existingClinicalInfo);
        

        // Update relationships: Insurance
        Insurance updatedInsurance = updatedPatientWithRelations.getPatientRelations().getInsurance();
        Insurance existingInsurance = existingPatient.getPatientRelations().getInsurance();
        existingInsurance.setBin(updatedInsurance.getBin());
        existingInsurance.setFirstName(updatedInsurance.getFirstName());
        existingInsurance.setLastName(updatedInsurance.getLastName());
        // save the updated insurance
        insuranceRepository.save(existingInsurance);
 
        // Update relationships: Contacts
        List<Contact> updatedContacts = updatedPatientWithRelations.getPatientRelations().getContacts();
        List<Contact> existingContacts = existingPatient.getPatientRelations().getContacts();
        contactRepository.deleteAll(existingContacts);
        existingContacts.addAll(updatedContacts);
        //save the updated contacts
        // for each contact in the list of contacts, set the patient relations to the existing patient relations
existingContacts.forEach(contact ->contact.setPatientRelations(existingPatient.getPatientRelations()));
        contactRepository.saveAll(existingContacts);
        
    
        // Update relationships: Prescriptions
        List<Prescription> updatedPrescriptions = updatedPatientWithRelations.getPatientRelations().getPrescription();
        List<Prescription> existingPrescriptions = existingPatient.getPatientRelations().getPrescription();
        prescriptionRepository.deleteAll(existingPrescriptions);
        existingPrescriptions.addAll(updatedPrescriptions);
        existingPrescriptions.forEach(prescription -> prescription.setPatientRelations(existingPatient.getPatientRelations()));
    
        // Update relationships: Addresses
        List<Address> updatedAddresses = updatedPatientWithRelations.getPatientRelations().getAddress();
        List<Address> existingAddresses = existingPatient.getPatientRelations().getAddress();
        addressRepository.deleteAll(existingAddresses);
        existingAddresses.addAll(updatedAddresses);
        existingAddresses.forEach(address -> address.setPatientRelations(existingPatient.getPatientRelations()));
    
        // Update relationships: Prescriber
        Prescriber updatedPrescriber = updatedPatientWithRelations.getPatientRelations().getPrescriber();
        Prescriber existingPrescriber = existingPatient.getPatientRelations().getPrescriber();
        existingPrescriber.setNpi(updatedPrescriber.getNpi());
        existingPrescriber.setFirstName(updatedPrescriber.getFirstName());
        existingPrescriber.setLastName(updatedPrescriber.getLastName());
        existingPrescriber.setTitle(updatedPrescriber.getTitle());
    
        // Set the updated Prescriber back to the existing PatientRelations
        existingPatient.getPatientRelations().setPrescriber(existingPrescriber);
    
        // Save the updated patient entity
        return patientRepository.save(existingPatient);
    }
    
     public List<Patient> getAllPatients()
    {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }
 
    // public Patient savePatient(Patient patient)
    // {
    //     return patientRepository.save(patient);
    // }

    public Patient getPatient(Long id)
    {
        Patient newPatient = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
        {
            newPatient = patient.get();
        }
        return newPatient;
    }

    // public Patient updatePatient(Patient patient) {
    // 	return patientRepository.save(patient);
    // }
    
    public String deleteById(Long id)
    {
        patientRepository.deleteById(id);
        return "Deleted Patient with patient id "+id;
    }
}

