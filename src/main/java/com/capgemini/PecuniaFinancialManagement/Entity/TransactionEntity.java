package com.capgemini.PecuniaFinancialManagement.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class TransactionEntity {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name="transaction_id")
	Long transactionId;
	
	@Column(name="transaction_type")
	String transactionType;
	
	@Column(name="transacton_mode")
	String transactionMode;
	
	@Column(name="transaction_date")
	LocalDate tdm;
	
	@Column(name="transaction_time")
	LocalTime transactionTime;
	public LocalTime getTransactionTime() {
		return transactionTime;
	}



	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Column(name="transaction_amount")
	double transactionAmount;
	
	@Column(name="benificiary_account")
	Long benificiaryAccount;
	
	@Column(name="payee_account")
	Long payeeAccount;
	
	
	public Long getBenificiaryAccount() {
		return benificiaryAccount;
	}



	public void setBenificiaryAccount(Long benificiaryAccount) {
		this.benificiaryAccount = benificiaryAccount;
	}



	public Long getPayeeAccount() {
		return payeeAccount;
	}



	public void setPayeeAccount(Long payeeAccount) {
		this.payeeAccount = payeeAccount;
	}



	public TransactionEntity(Long transactionId,String transactionType, String transactionMode, LocalDate tdm, double transactionAmount,Long benificiaryAccount, Long payeeAccount,LocalTime transactionTime)
	{
		
		this.transactionId=transactionId;
		this.tdm=tdm;
		this.transactionMode=transactionMode;
		this.transactionType=transactionType;
		this.transactionAmount=transactionAmount;
		this.benificiaryAccount=benificiaryAccount;
		this.payeeAccount=payeeAccount;
		this.transactionTime=transactionTime;
	}
	

	
	public double getTransactionAmount() {
		return transactionAmount;
	}



	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}



	public TransactionEntity() {}
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public LocalDate getTdm() {
		return tdm;
	}

	public void setTdm(LocalDate tdm) {
		this.tdm = tdm;
	}
}
