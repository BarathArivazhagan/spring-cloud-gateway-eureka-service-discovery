package com.barath.customer.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.customer.app.dto.Bank;
import com.barath.customer.app.entity.Customer;
import com.barath.customer.app.service.BankDetailService;
import com.barath.customer.app.service.CustomerService;

@RestController
public class CustomerDetailController {
	

	
	private final CustomerService customerService;
	
	private final BankDetailService bankService;


	public CustomerDetailController(CustomerService customerService, BankDetailService bankService) {
		this.bankService=bankService;
		this.customerService=customerService;
	}

	@GetMapping(value="/customer/details")
	public Map<String,Object> getCustomerBankDetails(@RequestParam Long customerId){
		
		Map<String,Object> response = new HashMap<>();
		Customer customer = customerService.getCustomer(customerId).get();
		response.put("customer", customer);
		Bank bank=bankService.getBankDetails(customer.getBankId());
		response.put("bank", bank);		
		return response; 
	}
	
	
	
	

}
