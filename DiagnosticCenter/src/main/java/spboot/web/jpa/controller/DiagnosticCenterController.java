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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spboot.web.jpa.entity.Customer;
import spboot.web.jpa.entity.DiagnosticCenter;
import spboot.web.jpa.service.DiagnosticCenterService;

@RestController
@RequestMapping
public class DiagnosticCenterController
{
	@Autowired
	DiagnosticCenterService diagnosticCenterService;
	
	@GetMapping(value="/diagnosticCenter/{DiagnosticCenterId}",produces="application/json")
	public ResponseEntity<DiagnosticCenter> getDiagnosticsId(@PathVariable int DiagnosticCenterId)
	{
		Optional<DiagnosticCenter> diag = diagnosticCenterService.getDiagnosticCenterId(DiagnosticCenterId);
		if(diag.isPresent())
			return new ResponseEntity<DiagnosticCenter>(diag.get(),HttpStatus.OK);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/diagnosticCenter",produces="application/json")
	public ResponseEntity<List<DiagnosticCenter>> getDiagnosticCenterDetails(){
		return new ResponseEntity<List<DiagnosticCenter>>(diagnosticCenterService.getDiagnosticCenters(),HttpStatus.OK);
	}
	
	@PostMapping(value="/diagnosticCenter",consumes="application/json")
	public HttpStatus addDiagnosticCenterDetails(@RequestBody DiagnosticCenter diagnosticCenter) {
		if(diagnosticCenterService.addOrModifyDiagnosticCenter(diagnosticCenter))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/diagnosticCenter",consumes="application/json")
	public HttpStatus modifyDiagnosticCenterDetails(@RequestBody DiagnosticCenter diagnosticCenter) {
		if(diagnosticCenterService.addOrModifyDiagnosticCenter(diagnosticCenter))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/diagnosticCenter/{diagnosticCenterId}")
	public HttpStatus removeDiagnosticCenterDetails(@PathVariable int diagnosticCenterId) {
		diagnosticCenterService.removeDiagnosticCenter(diagnosticCenterId);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}

}
