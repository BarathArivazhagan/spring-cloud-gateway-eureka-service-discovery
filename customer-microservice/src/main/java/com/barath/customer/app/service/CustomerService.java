package com.barath.customer.app.service;


import org.springframework.stereotype.Service;

import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.PostConstruct;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	

	public CustomerService(CustomerRepository customerRepository){
		this.customerRepository=customerRepository;
	}
	
	public Customer addCustomer(Customer customer){
		 return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCustomer(final long customerId){

		return customerRepository.findById(customerId);

	}

	public Customer updateCustomer(Customer customer){

		return addCustomer(customer);
	}
	public void deleteCustomer(long customerId){

		customerRepository.deleteById(customerId) ;

	}
	public void deleteCustomer(Customer customer){
		if(isCustomerExists(customer)){
			customerRepository.delete(customer) ;
		}
	}
	
	public boolean isCustomerExists(long customerId){
		return customerRepository.existsById(customerId);
	}
	
	public boolean isCustomerExists(Customer customer){
		if(Objects.nonNull(customer)){
			return customerRepository.existsById(customer.getCustomerId());
		}
		return false;
	}

	public Customer getCustomer(String customerName) {
		
		return customerRepository.findByCustomerName(customerName);
	}

	public List<Customer> getCustomers() {
		
		return this.customerRepository.findAll();
	}
	
	
	@PostConstruct
	public void init() {
		
		Customer customer1 = new Customer(1L, "BARATH",1L);
		Customer customer2 = new Customer(2L, "JOHN",1L);
		Customer customer3 = new Customer(3L, "DAVID",2L);
		Arrays.asList(customer1,customer2,customer3)
			.forEach(customerRepository::save);
		
	}
	
	

}
