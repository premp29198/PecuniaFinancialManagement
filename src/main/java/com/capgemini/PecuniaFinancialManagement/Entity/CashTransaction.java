package com.capgemini.PecuniaFinancialManagement.Entity;

public class CashTransaction {

	double amount;
	Long accountNumber;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
}
