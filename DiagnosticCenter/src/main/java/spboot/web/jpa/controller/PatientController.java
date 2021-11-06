package spboot.web.jpa.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import spboot.web.jpa.entity.Patient;
import spboot.web.jpa.service.PatientService;

@RestController
public class PatientController 
{
		@Autowired
		PatientService patientService;
		
		@GetMapping(value="/patients/{patientId}",produces="application/json")
		public ResponseEntity<Patient> getPatient(@PathVariable int patientId)
		{
			Optional<Patient> pat = patientService.getPatientId(patientId);
			if(pat.isPresent())
				return new ResponseEntity<Patient>(pat.get(),HttpStatus.OK);
			return new ResponseEntity(null,HttpStatus.NO_CONTENT);
		}
		
		@GetMapping(value="/patients",produces="application/json")
		public ResponseEntity<List<Patient>> getPatientDetails(){
			return new ResponseEntity<List<Patient>>(patientService.getPatients(),HttpStatus.OK);
		}
		
		@PostMapping(value="/patients",consumes="application/json")
		public HttpStatus addPatientDetails(@RequestBody Patient patient) {
			if(patientService.addOrModifyPatient(patient))
				return HttpStatus.OK;
			return HttpStatus.NOT_MODIFIED;
		}

		@PutMapping(value="/patients",consumes="application/json")
		public HttpStatus modifyPatientDetails(@RequestBody Patient patient) {
			if(patientService.addOrModifyPatient(patient))
				return HttpStatus.OK;
			return HttpStatus.NOT_MODIFIED;
		}
		
		//@PutMapping(value="/{")

		@DeleteMapping(value="/patients/{patientId}")
		public HttpStatus removePatientDetails(@PathVariable int patientId) {
			patientService.removePatient(patientId);
			return HttpStatus.OK;
		}
		@ExceptionHandler(RuntimeException.class)
		public HttpStatus noDataFound() {
			return HttpStatus.NO_CONTENT;
		}
}