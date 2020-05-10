package com.capgemini.PecuniaFinancialManagement.Dao;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.AccountRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.ChequeRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.TransactionRepository;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;
@Component
public class CreditDAOImpl implements ICreditDAO{

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	ChequeRepository chequeRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void saveChequeDetails(ChequeEntity currentChequeDetails) {
		// TODO Auto-generated method stub
		chequeRepository.save(currentChequeDetails);
	}



	@Override
	public AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity benificiaryAccountDetails = accountRepository.findById(benificiaryAccount)
		          .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + benificiaryAccount));
		        return benificiaryAccountDetails;
	
	}

	@Override
	public AccountEntity getPayeeAccount(Long payeeAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity payeeAccountDetails = accountRepository.findById(payeeAccount)
        .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + payeeAccount));
		      return  payeeAccountDetails;
		
	
	}

	@Override
	public void saveTransaction(Long transactionId,Long benificaryAccount, Long payeeAccount, String transactionMode, double amount,
			String transactionType,LocalDate transactionDate,LocalTime transactionTime) {
		// TODO Auto-generated method stub
		transactionRepository.save(new TransactionEntity(transactionId,transactionType,transactionMode,transactionDate,amount,benificaryAccount, payeeAccount,transactionTime));
		}

	@Override
	public void deleteAccountById(Long accountNumber) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(accountNumber);	}

	@Override
	public void saveAccountById(AccountEntity account) {
		// TODO Auto-generated method stub
		
accountRepository.save(account);
	}
	
}
