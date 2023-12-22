package org.application.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.application.entity.Patient;
import org.application.service_impletation.PatientService;



@RestController
public class PatientController {
	
	@Autowired
	private PatientService pService;
	
	@GetMapping("/patients")
	 List<Patient> getPatients(){
		return pService.getAllPatients();
	}
	
	@GetMapping("/patients/{id}")
	Patient getPatient(@PathVariable("id") Long id) {
		return pService.getPatient(id);
	}
	
	@PostMapping("/patients")
	Patient savePatientWithRelations(@RequestBody Patient patientWithRelations) {
		return pService.savePatientWithRelations(patientWithRelations);
    }
	// Patient savePatient(@RequestBody Patient patient) {
	// 	return pService.savePatient(patient);
	// }
	
	@PutMapping("/patients/{id}")
	// Patient updatePatient(@RequestBody Patient patient,@PathVariable("id")Long id) {
	// 	patient.setId(id);
	// 	return pService.updatePatient(patient);
	// }

	public Patient updatePatientWithRelations(@RequestBody Patient updatedPatient, @PathVariable("id") Long id) 	{
		updatedPatient.setId(id);
        return pService.updatePatientWithRelations(updatedPatient);
    }
	
	@DeleteMapping("/patients/{id}")
	String deletePatient(@PathVariable("id") Long id)
	{
		pService.deleteById(id);
		return "Patient removed for id "+id;
	}
}

