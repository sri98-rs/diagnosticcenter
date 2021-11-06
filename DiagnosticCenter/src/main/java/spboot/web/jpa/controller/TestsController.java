
//-------------------------------------------------------------------------------
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
//import spboot.web.jpa.entity.DiagnosticCenter;
import spboot.web.jpa.entity.Tests;
import spboot.web.jpa.service.TestsService;
@RestController
public class TestsController
{
    @Autowired
    TestsService testsService;
    
    @GetMapping(value="/tests/{TestsId}",produces="application/json")
	public ResponseEntity<Tests> getTests(@PathVariable int TestsId)
	{
		Optional<Tests> tes = testsService.getTestsId(TestsId);
		if(tes.isPresent())
			return new ResponseEntity<Tests>(tes.get(),HttpStatus.OK);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
    
    @GetMapping(value="/tests",produces="application/json")
    public ResponseEntity<List<Tests>> getTestsDetails()
    {
    	return new ResponseEntity<List<Tests>>(testsService.getTests(),HttpStatus.OK);
    }
    @PostMapping(value="/tests",consumes="application/json")
    public HttpStatus addTestsDetails(@RequestBody Tests tests) 
    {
    	if(testsService.addOrModifyTests(tests))
    		return HttpStatus.OK;
    	return HttpStatus.NOT_MODIFIED;
    }

    @PutMapping(value="/tests",consumes="application/json")
    public HttpStatus modifyTestAppointmentDetails(@RequestBody Tests tests) 
    {
    	if(testsService.addOrModifyTests(tests))
    		return HttpStatus.OK;
    	return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping(value="/tests/{testsId}")
    public HttpStatus removeTestsDetails(@PathVariable int testsId) 
    {
    	testsService.removeTests(testsId);
    	return HttpStatus.OK;
    }
    @ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}

}
