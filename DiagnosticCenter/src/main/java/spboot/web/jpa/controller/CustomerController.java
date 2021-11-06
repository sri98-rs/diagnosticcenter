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
import spboot.web.jpa.service.CustomerService;

@RestController
@RequestMapping
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/customers/{customerId}",produces="application/json")
	public ResponseEntity<Customer> getCustomer(@PathVariable int customerId)
	{
		Optional<Customer> customer = customerService.getCustomerId(customerId);
		if(customer.isPresent())
			return new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
	//-----------------------------------------------------------------
	
	@GetMapping(value="/customers",produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerDetails(){
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(),HttpStatus.OK);
	}
	@PostMapping(value="/customers",consumes="application/json")
	public HttpStatus addCustomerDetails(@RequestBody Customer customer) {
		if(customerService.addOrModifyCustomer(customer))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/customers",consumes="application/json")
	public HttpStatus modifyCustomerDetails(@RequestBody Customer customer) {
		if(customerService.addOrModifyCustomer(customer))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/customers/{customerId}")
	public HttpStatus removeCustomerDetails(@PathVariable int customerId) {
		customerService.removeCustomer(customerId);
		return HttpStatus.OK;
	}
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus noDataFound() {
		return HttpStatus.NO_CONTENT;
	}
	

}