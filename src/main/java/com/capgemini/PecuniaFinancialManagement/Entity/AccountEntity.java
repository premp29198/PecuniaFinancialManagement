package com.capgemini.PecuniaFinancialManagement.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountdetails")
public class AccountEntity {

	@Id
	@Column(name="account_number")
	Long accountNumber;
	
	@Column(name="account_holder_name")
	String accountHolderName;
	
	@Column(name="balance")
	double balance;


	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

public AccountEntity(Long accountNumber, String accountHolderName, double balance)
{
	this.accountHolderName=accountHolderName;
	this.accountNumber=accountNumber;
	this.balance=balance;
}
public AccountEntity() {}
}


