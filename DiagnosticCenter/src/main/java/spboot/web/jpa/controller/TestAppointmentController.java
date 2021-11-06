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

import spboot.web.jpa.entity.TestAppointment;
import spboot.web.jpa.entity.TestAppointmentTests;
import spboot.web.jpa.service.TestAppointmentService;
import spboot.web.jpa.service.TestAppointmentTestsService;


@RestController
public class TestAppointmentController {
@Autowired
TestAppointmentService testAppointmentService;

@GetMapping(value="/testAppointment/{testAppointmentId}",produces="application/json")
public ResponseEntity<TestAppointment> getTestAppointmentTestsId(@PathVariable int testAppointmentId)
   {
           Optional<TestAppointment> testAppTest = testAppointmentService.getTestAppointment(testAppointmentId);
           if(testAppTest.isPresent())
                   return new ResponseEntity<TestAppointment>(testAppTest.get(),HttpStatus.OK);
           return new ResponseEntity(null,HttpStatus.NO_CONTENT);
   }

	@GetMapping(value="/testAppointment",produces="application/json")
	public ResponseEntity<List<TestAppointment>> getTestAppointmentDetails()
	{
		return new ResponseEntity<List<TestAppointment>>(testAppointmentService.getTestAppointments(),HttpStatus.OK);
	}
	
	@PostMapping(value="/testAppointment",consumes="application/json")
	public HttpStatus addTestAppointmentDetails(@RequestBody TestAppointment testAppointment) 
	{
		if(testAppointmentService.addOrModifyTestAppointment(testAppointment))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/testAppointment",consumes="application/json")
	public HttpStatus modifyTestAppointmentDetails(@RequestBody TestAppointment testAppointment) 
	{
		if(testAppointmentService.addOrModifyTestAppointment(testAppointment))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/testAppointment/{testAppointmentId}")
	public HttpStatus removeTestAppointmentDetails(@PathVariable int testAppointmentId) 
	{
		testAppointmentService.removeTestAppointment(testAppointmentId);
		return HttpStatus.OK;
	}
}