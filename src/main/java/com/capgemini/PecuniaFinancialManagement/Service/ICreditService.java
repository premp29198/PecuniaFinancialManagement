package com.capgemini.PecuniaFinancialManagement.Service;


import java.util.ArrayList;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.GlobalExceptionHandler;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface ICreditService {

public void saveChequeDetails(ChequeEntity currentChequeDetails) throws ResourceNotFoundException;


public void updateChequeAccount(AccountEntity benificiaryAccountDetails, AccountEntity payeeAccountDetails, double amount)  ;
	
public void updateCashAccount(AccountEntity benificiaryAccountDetails, double amount) ;

public AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException;

public AccountEntity getPayeeAccount(Long payeeAccount) throws ResourceNotFoundException;
 public void saveTransaction(Long benificaryAccount, Long payeeAccount, String transactionMode,double amount, String transactionType);

void saveCashTransaction(CashTransaction cash) throws ResourceNotFoundException;
}
