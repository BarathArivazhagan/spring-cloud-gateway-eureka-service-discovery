package com.barath.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.bank.app.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Long>{

	public Bank findByBankName(String bankName);
	
}
