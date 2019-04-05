package com.barath.bank.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.service.BankService;

@RestController
public class BankController {

	private final BankService bankService;
		
	
	public BankController(BankService bankService) {
		super();
		this.bankService = bankService;
	}

	@GetMapping("/")
	public String handleHome(){
		return "Welcome to Bank Application";
	}
	
	@PostMapping(value="/bank")
	public Bank addBank(@RequestBody Bank bank){
		
		return bankService.addBank(bank);
	
		
	}
	
	
	@GetMapping(value="/bank")
	public Optional<Bank> getBank(@RequestParam("id") long bankId){
		
		return bankService.getBank(bankId);
	}
	
	@GetMapping(value="/bank/byName")
	public Bank getBank(@RequestParam("name") String bankName){
		return bankService.getBank(bankName);
	}
	
	@PutMapping(value="/bank")
	public Bank updateBank(@RequestBody Bank bank){
		return bankService.updateBank(bank);
	}
	
	@GetMapping(value="/banks")
	public List<Bank> getAllBanks(){
		return bankService.getBanks();
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleeError(Exception ex){
		return ex.getMessage();
	}
	
	

}
