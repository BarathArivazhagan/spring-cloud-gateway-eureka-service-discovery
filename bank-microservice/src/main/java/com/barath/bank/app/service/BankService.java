package com.barath.bank.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.barath.bank.app.entity.Bank;
import com.barath.bank.app.repository.BankRepository;

@Service
public class BankService {
	
	private final BankRepository bankRep; 
	

	public BankService(BankRepository bankRep){
		this.bankRep=bankRep;
	}
	
	public Bank addBank(Bank bank){
		return bankRep.save(bank);
	}
	
	public Optional<Bank> getBank(long bankId){
		
		return bankRep.findById(bankId);
		
	}

	public Bank updateBank(Bank bank){
	
		return	bankRep.save(bank);
		
	}
	public void deleteBank(long bankId){
		if(isBankExists(bankId)){
			bankRep.deleteById(bankId) ;
		}
	}
	public void deleteBank(Bank bank){
		if(isBankExists(bank)){
			bankRep.delete(bank) ;
		}
	}
	
	public boolean isBankExists(long bankId){
		return bankRep.existsById(bankId);
	}
	
	public boolean isBankExists(Bank bank){
		if(bank != null){
			return bankRep.existsById(bank.getBankId());
		}
		return false;
	}

	public Bank getBank(String bankName) {
		
		return bankRep.findByBankName(bankName);
	}

	public List<Bank> getBanks() {		
		return bankRep.findAll();
	}

	@PostConstruct
	public void init() {
		
		Bank bank1 = new Bank(1L, "CITI");
		Bank bank2 = new Bank(2L,"HDFC");
		Bank bank3 = new Bank(2L,"DBS");
		Arrays.asList(bank1, bank2,bank3)
			.forEach(bankRep::save);
	}
	

}
