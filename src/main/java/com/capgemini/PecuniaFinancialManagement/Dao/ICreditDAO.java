package com.capgemini.PecuniaFinancialManagement.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.GlobalExceptionHandler;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface ICreditDAO {
	public void saveChequeDetails(ChequeEntity currentChequeDetails);



	public AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException;

	public AccountEntity getPayeeAccount(Long payeeAccount)  throws ResourceNotFoundException;
	
	public void saveTransaction(Long transactionId,Long benificaryAccount, Long payeeAccount, String transactionMode,double amount, String transactionType,LocalDate transactionDate,LocalTime transactionTime);
	
	public void deleteAccountById(Long accountNumber); 

	public void saveAccountById(AccountEntity account);
}