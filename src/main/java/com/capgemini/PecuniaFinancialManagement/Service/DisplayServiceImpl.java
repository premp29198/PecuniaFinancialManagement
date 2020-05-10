package com.capgemini.PecuniaFinancialManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.PecuniaFinancialManagement.Dao.IDisplayDAO;
import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Service
public class DisplayServiceImpl implements IDisplayService{

@Autowired
IDisplayDAO displayDao;

	@Override	
	public ResponseEntity<ChequeEntity> getChequeById(Integer chequeNumber ) throws ResourceNotFoundException
	{
		ResponseEntity<ChequeEntity> cheque= displayDao.getChequeById(chequeNumber);
	
		return cheque;
		
	}


	@Override
	public List<AccountEntity> getAllAccount() 
	{
		// TODO Auto-generated method stub

		List<AccountEntity> accountList = displayDao.getAllAccount();
		return accountList;
	}

	@Override
	public List<TransactionEntity> getAllTransaction() {
		// TODO Auto-generated method stub
		List<TransactionEntity> transactionList=displayDao.getAllTransaction();
		return transactionList;
	}
	
	@Override
	public List<ChequeEntity> getAllCheque()
	{
		List<ChequeEntity> chequeList =displayDao.getAllCheque();
	 return chequeList;
	}


	@Override
	public List<CustomerEntity> getAllCustomer() {
		// TODO Auto-generated method stub
		List<CustomerEntity> customerList =displayDao.getAllCustomer();
		return customerList;
	}
}
