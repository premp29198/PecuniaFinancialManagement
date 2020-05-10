package com.capgemini.PecuniaFinancialManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface IDisplayDAO {
	 public List<TransactionEntity> getAllTransaction();

	 public List<ChequeEntity> getAllCheque();

	 public ResponseEntity<ChequeEntity> getChequeById(Integer chequeNumber ) throws ResourceNotFoundException;

	 public List<AccountEntity> getAllAccount();
	 
	 public List<CustomerEntity> getAllCustomer();

	ResponseEntity<AccountEntity> getAccountById(Long accountNumber) throws ResourceNotFoundException;
}
