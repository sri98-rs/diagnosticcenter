package spboot.web.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spboot.web.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
