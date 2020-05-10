package com.capgemini.PecuniaFinancialManagement.Dao;

import org.springframework.http.ResponseEntity;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface IDebitDAO {

	
	public void saveChequeDetails(ChequeEntity currentChequeDetails);

	AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException;

	AccountEntity getPayeeAccount(Long payeeAccount) throws ResourceNotFoundException;

	void deleteAccountById(Long accountNumber);
	
	void saveAccount(AccountEntity accountDetails);
	
}
