package com.barath.customer.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	

	private static final long serialVersionUID = 9169163509278571062L;


	@Id
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	
	@Column(name="BANK_ID")
	private Long bankId;


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
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
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}


	public Customer() {
		super();
		
	}


	public Customer(Long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}


	public Customer(Long customerId, String customerName, Long bankId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.bankId = bankId;
	}


	public Long getBankId() {
		return bankId;
	}


	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	
	
	

}
