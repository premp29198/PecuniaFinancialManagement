package com.capgemini.PecuniaFinancialManagement.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.PecuniaFinancialManagement.Dao.IPassbookDAO;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Service
public class PassbookServiceImpl implements IPassbookService{

	@Autowired
	IPassbookDAO passbookDao;
	
	@Override
	public List<TransactionEntity> displaypassbookByAccountnumber(long accountNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<TransactionEntity> accountCheck = passbookDao.getAccountById(accountNumber);
		List<TransactionEntity> passbook = new ArrayList<TransactionEntity>();
		if(accountCheck.isPresent())
			passbook =passbookDao.getPassbookById(accountNumber);
		else 
			throw new ResourceNotFoundException("Account Does not exist");
		return passbook;
	}

	@Override
	public List<TransactionEntity> displaypassbookByDate(long accountNumber, LocalDate startDate, LocalDate endDate) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<TransactionEntity> accountCheck = passbookDao.getAccountById(accountNumber);
		List<TransactionEntity> passbook = new ArrayList<TransactionEntity>();
		if(accountCheck.isPresent())
		{
			passbook = passbookDao.displaypassbookByDate1(accountNumber, startDate, endDate);
		}
		else
			throw new ResourceNotFoundException("Account does not exist");

		
		return passbook;
	}

	@Override
	public List<TransactionEntity> updatePassbook(long accountNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<TransactionEntity>accountExists=passbookDao.getAccountById(accountNumber);
		List<TransactionEntity> passbook= new ArrayList<TransactionEntity>();
				
		if(accountExists.isPresent()) {
		passbook=passbookDao.getPassbookById(accountNumber);
		passbookDao.updatepassbookByAccountnumber(accountNumber);}
		else 
			throw new ResourceNotFoundException("Account Does not exist");
		return passbook;
	}

}
