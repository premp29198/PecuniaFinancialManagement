package com.capgemini.PecuniaFinancialManagement.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.TransactionRepository;

@Component
public class PassbookDAOImpl implements IPassbookDAO{

	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public Optional<TransactionEntity> getAccountById(long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionEntity> getPassbookById(long accountNumber) {
		// TODO Auto-generated method stub

		List<TransactionEntity> passbook = transactionRepository.displaypassbookByAccountnumber1(accountNumber);
		return passbook;
	}

	@Override
	public List<TransactionEntity> displaypassbookByDate1(Long accountNumber, LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		List<TransactionEntity> passbook =transactionRepository.displaypassbookByDate1(accountNumber, startDate, endDate);
		return passbook;
	}

	@Override
	public void updatepassbookByAccountnumber(long accountNumber) {
		// TODO Auto-generated method stub
		transactionRepository.updatepassbookByAccountnumber1(accountNumber);

	}

}
