package com.capgemini.PecuniaFinancialManagement.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.PecuniaFinancialManagement.Dao.IDebitDAO;
import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.exception.GlobalExceptionHandler;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Service
public class DebitServiceImpl implements IDebitService{
//
//	@Autowired
//	TransactionRepository transactionRepository;
//	@Autowired
//	ChequeRepository chequeRepository;
//	
//	@Autowired
//	AccountRepository accountRepository;
	
	@Autowired
	CreditServiceImpl creditServiceObject;
	
	@Autowired
	IDebitDAO debitDao;
	
	
	@Override
public void saveChequeDetails(ChequeEntity currentChequeDetails) throws ResourceNotFoundException  {
	// TODO Auto-generated method stub
	//chequeRepository.save(currentChequeDetails);
debitDao.saveChequeDetails(currentChequeDetails);
	AccountEntity benificiaryAccountDetails =debitDao.getBenificiaryAccount(currentChequeDetails.getBenificiaryAccount());
	
	AccountEntity payeeAccountDetails =debitDao.getPayeeAccount(currentChequeDetails.getPayeeAccount());
	
	updateChequeAccount(benificiaryAccountDetails,payeeAccountDetails,currentChequeDetails.getAmount());
	creditServiceObject.saveTransaction(currentChequeDetails.getBenificiaryAccount(),currentChequeDetails.getPayeeAccount(),"Cheque", currentChequeDetails.getAmount(), "Debit");
}
	@Override
	public void updateChequeAccount(AccountEntity benificiaryAccountDetails, AccountEntity payeeAccountDetails, double amount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		double payeeBalance = payeeAccountDetails.getBalance();
		double benificiaryBalance = benificiaryAccountDetails.getBalance();
		
		payeeBalance = payeeBalance-amount;
		benificiaryBalance = benificiaryBalance+amount;
		if(payeeBalance <0)
		{
			throw new ResourceNotFoundException("Account Balance 0");
			}
		
		benificiaryAccountDetails.setBalance(benificiaryBalance);

	debitDao.deleteAccountById(benificiaryAccountDetails.getAccountNumber());
		
		debitDao.saveAccount(benificiaryAccountDetails);
		payeeAccountDetails.setBalance(payeeBalance);
		debitDao.deleteAccountById(payeeAccountDetails.getAccountNumber());
		debitDao.saveAccount(payeeAccountDetails);

		
	}
	
//	@Override
//	public AccountDetails getBenificiaryAccount(Long benificiaryAccount) {
//		// TODO Auto-generated method stub
//		Optional<AccountDetails> benificiaryAccountDetails = accountRepository.findById(benificiaryAccount);
//		return benificiaryAccountDetails.get();
//	}
//	
//	@Override
//	public AccountDetails getPayeeAccount(Long payeeAccount) {
//		// TODO Auto-generated method stub
//		Optional<AccountDetails> payeeAccountDetails = accountRepository.findById(payeeAccount);
//		return payeeAccountDetails.get();
//	
//	}
//
//	@Override
//	public void saveCashTransaction(Long accountNumber, double amount) throws ResourceNotFoundException
//	{
//	}


	@Override
	public void updateCashAccount(AccountEntity benificiaryAccountDetails, double amount) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		
		double benificiaryBalance = benificiaryAccountDetails.getBalance();
		
		benificiaryBalance = benificiaryBalance-amount;
		
		benificiaryAccountDetails.setBalance(benificiaryBalance);
		debitDao.deleteAccountById(benificiaryAccountDetails.getAccountNumber());
		debitDao.saveAccount(benificiaryAccountDetails);

		
		
	}
	@Override
	public void saveCashTransaction(CashTransaction cash) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		

		AccountEntity benificiaryAccountDetails =debitDao.getBenificiaryAccount(cash.getAccountNumber());
		updateCashAccount(benificiaryAccountDetails,cash.getAmount());
		creditServiceObject.saveTransaction(cash.getAccountNumber(),cash.getAccountNumber(), "Cash",cash.getAmount() ,"Debit" );
	
	}
	

}
