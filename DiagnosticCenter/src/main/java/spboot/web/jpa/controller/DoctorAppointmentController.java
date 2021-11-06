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
import spboot.web.jpa.service.DoctorAppointmentService;

@RestController
public class DoctorAppointmentController {
@Autowired
DoctorAppointmentService doctorAppointmentService;

@GetMapping(value="/doctorAppointment/{DoctorAppointmentId}",produces="application/json")
public ResponseEntity<DoctorAppointment> getDoctorAppointmentId(@PathVariable int DoctorAppointmentId)
    {
            Optional<DoctorAppointment> docApp = doctorAppointmentService.getDoctorAppointmentServiceId(DoctorAppointmentId);
            if(docApp.isPresent())
                    return new ResponseEntity<DoctorAppointment>(docApp.get(),HttpStatus.OK);
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
//------------------------------------------------------------------------------------
	@GetMapping(value="/doctorAppointment",produces="application/json")
	public ResponseEntity<List<DoctorAppointment>> getDoctorAppointmentDetails(){
		return new ResponseEntity<List<DoctorAppointment>>(doctorAppointmentService.getDoctorAppointments(),HttpStatus.OK);
	}
	
//	@GetMapping(value="/doctorAppointment/{doctorId}/{doctorAppointmentDate}",produces="application/json")
//	public ResponseEntity<DoctorAppointment> findAppointmentsByDoctorIdAndDate(@PathVariable int doctorId,@PathVariable String doctorAppointmentDate){
//		System.out.println(doctorId+" "+doctorAppointmentDate+" Hello ");
//		
//		return new ResponseEntity<DoctorAppointment>(doctorAppointmentService.getAppointmentsByDoctorIdAndDate(doctorId,LocalDate.parse(doctorAppointmentDate)),HttpStatus.OK);
//	}
	
	
	@PostMapping(value="/doctorAppointment",consumes="application/json")
	public HttpStatus addDoctorAppointmentDetails(@RequestBody DoctorAppointment doctorAppointment) {
		if(doctorAppointmentService.addOrModifyDoctorAppointment(doctorAppointment))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}

	@PutMapping(value="/doctorAppointment",consumes="application/json")
	public HttpStatus modifyDoctorAppointmentDetails(@RequestBody DoctorAppointment doctorAppointment) {
		if(doctorAppointmentService.addOrModifyDoctorAppointment(doctorAppointment))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/doctorAppointment/{status}/{doctorAppointmentId}")
	public HttpStatus modifyDoctorAppointmentStatus(@PathVariable char status,@PathVariable int doctorAppointmentId){
		System.out.println("Hello");
		if(doctorAppointmentService.modifyDoctorAppointmentStatus(status, doctorAppointmentId))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}

	@DeleteMapping(value="/doctorAppointment/{doctorAppointmentId}")
	public HttpStatus removeCustomerDetails(@PathVariable int doctorAppointmentId) {
		doctorAppointmentService.removeDoctorAppointment(doctorAppointmentId);
		return HttpStatus.OK;
	}
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}

}
