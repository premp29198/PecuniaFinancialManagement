package com.capgemini.PecuniaFinancialManagement.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.PecuniaFinancialManagement.Dao.ICreditDAO;
import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.GlobalExceptionHandler;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;


@Service
public class CreditServiceImpl implements ICreditService{

@Autowired
ICreditDAO creditDao;
	
	final Long transactionId =Long.parseLong("1000000001");
	
	@Override
	public void saveChequeDetails(ChequeEntity currentChequeDetails) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
	
       creditDao.saveChequeDetails(currentChequeDetails);
		
		AccountEntity benificiaryAccountDetails =getBenificiaryAccount(currentChequeDetails.getBenificiaryAccount());
		
		AccountEntity payeeAccountDetails =getPayeeAccount(currentChequeDetails.getPayeeAccount());
		
		updateChequeAccount(benificiaryAccountDetails,payeeAccountDetails,currentChequeDetails.getAmount());
		saveTransaction(currentChequeDetails.getBenificiaryAccount(),currentChequeDetails.getPayeeAccount(),"Cheque", currentChequeDetails.getAmount(), "Credit");
	
	
	
	}
	
	@Override
	public void updateChequeAccount(AccountEntity benificiaryAccountDetails, AccountEntity payeeAccountDetails, double amount) {
		// TODO Auto-generated method stub
		
		double payeeBalance = payeeAccountDetails.getBalance();
		double benificiaryBalance = benificiaryAccountDetails.getBalance();
		
		payeeBalance = payeeBalance-amount;
		benificiaryBalance = benificiaryBalance+amount;
		if(payeeBalance <0)
		{
			
			}
		
		benificiaryAccountDetails.setBalance(benificiaryBalance);
		creditDao.deleteAccountById(benificiaryAccountDetails.getAccountNumber());
		//accountRepository.deleteById(benificiaryAccountDetails.getAccountNumber());
		creditDao.saveAccountById(benificiaryAccountDetails);
	//	accountRepository.save(benificiaryAccountDetails);
		System.out.println(benificiaryAccountDetails.getBalance());
	
		payeeAccountDetails.setBalance(payeeBalance);
		creditDao.deleteAccountById(payeeAccountDetails.getAccountNumber());
		creditDao.saveAccountById(payeeAccountDetails);
		
		
	}


	@Override
	public void saveTransaction(Long benificaryAccount, Long payeeAccount, String transactionMode,double amount, String transactionType)
	{
	
		LocalDate transactionDate=LocalDate.now();
		//transactionRepository.save(new Transaction(transactionType,transactionMode,transactionTime,amount,benificaryAccount, payeeAccount));
		Long transactionId = generateRandom(10);
		LocalTime transactionTime=LocalTime.now();
		creditDao.saveTransaction(transactionId,benificaryAccount, payeeAccount, transactionMode, amount, transactionType,transactionDate, transactionTime);
	}

	public static long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	
	
	@Override
	public AccountEntity getBenificiaryAccount(Long benificiaryAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		AccountEntity benificiaryAccountDetails = creditDao.getBenificiaryAccount(benificiaryAccount);
		return benificiaryAccountDetails;
	}
	
	@Override
	public AccountEntity getPayeeAccount(Long payeeAccount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		AccountEntity payeeAccountDetails = creditDao.getBenificiaryAccount(payeeAccount);

		return payeeAccountDetails;
	
	}


	@Override
	public void saveCashTransaction(CashTransaction cash) throws ResourceNotFoundException 
	{
	
				AccountEntity benificiaryAccountDetails =getBenificiaryAccount(cash.getAccountNumber());
				updateCashAccount(benificiaryAccountDetails,cash.getAmount());
				saveTransaction(cash.getAccountNumber(), cash.getAccountNumber(), "Cash", cash.getAmount(),"Credit" );		
			
		
		
	}


	@Override
	public void updateCashAccount(AccountEntity benificiaryAccountDetails, double amount)  {
		// TODO Auto-generated method stub
		
		
		double benificiaryBalance = benificiaryAccountDetails.getBalance();
		
		benificiaryBalance = benificiaryBalance+amount;
		
		benificiaryAccountDetails.setBalance(benificiaryBalance);
		creditDao.deleteAccountById(benificiaryAccountDetails.getAccountNumber());
		creditDao.saveAccountById(benificiaryAccountDetails);
		
	}
}
