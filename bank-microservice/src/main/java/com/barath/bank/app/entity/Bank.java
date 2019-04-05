package com.barath.bank.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK")
public class Bank {
	
	@Id
	@Column(name="BANK_ID")
	private long bankId;
	
	
	@Column(name="BANK_NAME")
	private String bankName;
	
	public Bank(long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		
	}

	public long getBankId() {
		return bankId;
	}


	public void setBankId(long bankId) {
		this.bankId = bankId;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bankId ^ (bankId >>> 32));
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (bankId != other.bankId)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}


	public Bank() {
		super();
		
	}


	

}
