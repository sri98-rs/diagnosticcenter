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

import spboot.web.jpa.entity.TestAppointmentTests;
import spboot.web.jpa.service.TestAppointmentTestsService;


@RestController
public class TestAppointmentTestsController {
	
	@Autowired
	TestAppointmentTestsService testAppointmentTestsService;
	
	@GetMapping(value="/testAppointmentTests/{testAppointmentTestsId}",produces="application/json")
	public ResponseEntity<TestAppointmentTests> getTestAppointmentTestDetails(@PathVariable int testAppointmentTestsId)
	   {
	           Optional<TestAppointmentTests> testAppTest = testAppointmentTestsService.getTestAppointmentTest(testAppointmentTestsId);
	           if(testAppTest.isPresent())
	                   return new ResponseEntity<TestAppointmentTests>(testAppTest.get(),HttpStatus.OK);
	           return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	   }

	@GetMapping(value="/testAppointmentTests",produces="application/json")
	public ResponseEntity<List<TestAppointmentTests>> getTestAppointmentTestsDetails()
	{
		return new ResponseEntity<List<TestAppointmentTests>>(testAppointmentTestsService.getTestAppointmentTests(),HttpStatus.OK);
	}
	
	@PostMapping(value="/testAppointmentTests",consumes="application/json")
	public HttpStatus addTestAppointmentTestsDetails(@RequestBody TestAppointmentTests testAppointmentTests) 
	{
		if(testAppointmentTestsService.addOrModifyTestAppointmentTests(testAppointmentTests))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/testAppointmentTests",consumes="application/json")
	public HttpStatus modifyTestAppointmentTestsDetails(@RequestBody TestAppointmentTests testAppointmentTests) 
	{
		if(testAppointmentTestsService.addOrModifyTestAppointmentTests(testAppointmentTests))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/testAppointmentTests/{testAppointmentTestsId}")
	public HttpStatus removeTestAppointmentTestsDetails(@PathVariable int testAppointmentTestsId) 
	{
		testAppointmentTestsService.removeTestAppointmentTests(testAppointmentTestsId);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}
}