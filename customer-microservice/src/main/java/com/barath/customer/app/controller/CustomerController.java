package com.barath.customer.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.service.CustomerService;

@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {
	

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/")
	public String handleHome(){
		return "Welcome to Customer Application";
	}
	
	@PostMapping(value="/customer")
	public String addCustomer(@RequestBody Customer customer){
		if(customer !=null){
			customerService.addCustomer(customer);
			return "Customer is added successfully";
		}
		return "Customer is not  added successfully. Check the logs for error ";
	}
	
	
	@GetMapping(value="/customer")
	public Optional<Customer> getCustomer(@RequestParam("id") long customerId){
		
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping(value="/customer/byName")
	public Customer getCustomer(@RequestParam("name") String customerName){
		return customerService.getCustomer(customerName);
	}

	
	@GetMapping(value="/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex){
		return ex.getMessage();
	}
	
	

}
