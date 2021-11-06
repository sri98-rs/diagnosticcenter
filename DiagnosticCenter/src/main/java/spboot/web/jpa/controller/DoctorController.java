package spboot.web.jpa.controller;

import java.time.LocalDate;
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

import spboot.web.jpa.entity.Customer;
import spboot.web.jpa.entity.Doctor;
import spboot.web.jpa.entity.DoctorAppointment;
import spboot.web.jpa.service.DoctorService;

@RestController
public class DoctorController
{
	@Autowired
	DoctorService doctorService;
	
	@GetMapping(value="/doctors/{doctorId}",produces="application/json")
	public ResponseEntity<Doctor> getDoctorId(@PathVariable int doctorId)
	{
		Optional<Doctor> doctor = doctorService.getDoctor(doctorId);
		if(doctor.isPresent())
			return new ResponseEntity<Doctor>(doctor.get(),HttpStatus.OK);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
	//-------------------------------------------------------------------------------------------
	
	@GetMapping(value="/doctors",produces="application/json")
	public ResponseEntity<List<Doctor>> getDoctorDetails(){
		return new ResponseEntity<List<Doctor>>(doctorService.getDoctors(),HttpStatus.OK);
	}
	
	@GetMapping(value="/doctors/{doctorId}/{doctorAppointmentDate}",produces="application/json")
	public ResponseEntity<List<DoctorAppointment>> findAppointmentsByDoctorIdAndDate(@PathVariable int doctorId,@PathVariable String doctorAppointmentDate){
		System.out.println(doctorId+" "+doctorAppointmentDate+" Hello ");
		
		return new ResponseEntity<List<DoctorAppointment>>(doctorService.getAppointmentsByDoctorIdAndDate(doctorId,LocalDate.parse(doctorAppointmentDate)),HttpStatus.OK);
	}
	
	@PostMapping(value="/doctors",consumes="application/json")
	public HttpStatus addDoctorDetails(@RequestBody Doctor doctor) {
		if(doctorService.addOrModifyDoctor(doctor))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/doctors",consumes="application/json")
	public HttpStatus modifyDoctorDetails(@RequestBody Doctor doctor) {
		if(doctorService.addOrModifyDoctor(doctor))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/doctors/{doctorId}")
	public HttpStatus removeDoctorDetails(@PathVariable int doctorId) {
		doctorService.removeDoctor(doctorId);
		return HttpStatus.OK;
	}
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}

}

