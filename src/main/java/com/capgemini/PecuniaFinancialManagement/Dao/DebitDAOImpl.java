package com.capgemini.PecuniaFinancialManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.AccountRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.ChequeRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.TransactionRepository;
import com.capgemini.PecuniaFinancialManagement.Service.CreditServiceImpl;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Component
public class DebitDAOImpl implements IDebitDAO{

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	ChequeRepository chequeRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CreditServiceImpl creditServiceObject;

	@Override
	public void saveChequeDetails(ChequeEntity currentChequeDetails) {
		// TODO Auto-generated method stub
		chequeRepository.save(currentChequeDetails);
	}
	
	@Override
	public AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity benificiaryAccountDetails = accountRepository.findById(benificiaryAccount)
		.orElseThrow(() -> new ResourceNotFoundException("Account not found for this account number" + benificiaryAccount));
        return benificiaryAccountDetails;
	}
	
	@Override
	public AccountEntity getPayeeAccount(Long payeeAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		AccountEntity payeeAccountDetails = accountRepository.findById(payeeAccount)
		.orElseThrow(() -> new ResourceNotFoundException("Account not found for this account number" + payeeAccount));
        return payeeAccountDetails;
		
	}

	@Override
	public void deleteAccountById(Long accountNumber) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(accountNumber);
	}

	@Override
	public void saveAccount(AccountEntity accountDetails) {
		// TODO Auto-generated method stub
		accountRepository.save(accountDetails);
	}


}
