package com.barath.customer.app.dto;

public class Bank {
	
	private Long bankId;
	
	private String bankName;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Bank(Long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}

	public Bank() {
		super();
		
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}
	
	
	
	

}
