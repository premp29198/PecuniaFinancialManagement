package com.capgemini.PecuniaFinancialManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.AccountRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.ChequeRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.CustomerRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.TransactionRepository;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Component
public class DisplayDAO implements IDisplayDAO{

	
	@Autowired
	ChequeRepository chequeRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;
	
	
	
	@Override
	public List<TransactionEntity> getAllTransaction() {
		// TODO Auto-generated method stub
		
		List<TransactionEntity> transactionList= (List<TransactionEntity>) transactionRepository.findAll();
		
		return transactionList;
	}

	@Override
	public List<ChequeEntity> getAllCheque() {
		// TODO Auto-generated method stub
		List<ChequeEntity> chequeList = (List<ChequeEntity>) chequeRepository.findAll();
		return chequeList;
	}

	@Override
	public ResponseEntity<ChequeEntity> getChequeById(Integer chequeNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		ChequeEntity cheque= chequeRepository.findById(chequeNumber)
		.orElseThrow(() -> new ResourceNotFoundException("Cheque not found for this cheque number" + chequeNumber));
        return ResponseEntity.ok().body(cheque);
	
		
	}

	@Override
	public List<AccountEntity> getAllAccount() {
		// TODO Auto-generated method stub

		List<AccountEntity> accountList = (List<AccountEntity>) accountRepository.findAll();
		
		return accountList;
	}
	@Override
	public ResponseEntity<AccountEntity> getAccountById(Long accountNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity cheque= accountRepository.findById(accountNumber)
		.orElseThrow(() -> new ResourceNotFoundException("account not found for this account number" + accountNumber));
        return ResponseEntity.ok().body(cheque);
	
		
	}
	
	@Override
	public List<CustomerEntity> getAllCustomer() {
		// TODO Auto-generated method stub
		List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepository.findAll();

		return customerList;
	}

}
