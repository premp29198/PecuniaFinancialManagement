package com.capgemini.PecuniaFinancialManagement.Service;



import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.GlobalExceptionHandler;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface IDebitService {
public void saveChequeDetails(ChequeEntity currentChequeDetails) throws ResourceNotFoundException;


public void updateChequeAccount(AccountEntity benificiaryAccountDetails, AccountEntity payeeAccountDetails, double amount) throws ResourceNotFoundException ;
	
public void updateCashAccount(AccountEntity benificiaryAccountDetails, double amount) throws ResourceNotFoundException ;
//
//public AccountDetails getBenificiaryAccount(Long benificiaryAccount);
//
//public AccountDetails getPayeeAccount(Long payeeAccount);

public void saveCashTransaction(CashTransaction cash) throws ResourceNotFoundException;


}
