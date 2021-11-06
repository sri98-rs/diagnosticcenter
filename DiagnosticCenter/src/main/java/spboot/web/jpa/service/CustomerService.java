package spboot.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spboot.web.jpa.entity.Customer;
import spboot.web.jpa.repository.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional(readOnly=true)
	public Optional<Customer> getCustomerId(int customerId){
		return customerRepository.findById(customerId);
	}
	
	@Transactional(readOnly=true)
	public List<Customer> getCustomers(){
		List<Customer> clist = customerRepository.findAll();
		return clist;

	}
	
	@Transactional 
	public boolean addOrModifyCustomer(Customer customer) {
		Customer cust = customerRepository.save(customer);
		return cust!=null;
	}
	
	@Transactional
	public void removeCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}
			
}
