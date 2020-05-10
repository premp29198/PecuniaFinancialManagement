package com.capgemini.PecuniaFinancialManagement.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;


public interface IPassbookDAO {

	

	public Optional<TransactionEntity> getAccountById(long accountNumber);

	public List<TransactionEntity> getPassbookById(long accountNumber);

	public List<TransactionEntity> displaypassbookByDate1(Long accountNumber, LocalDate startDate,LocalDate endDate);
	public void updatepassbookByAccountnumber(long accountNumber);
}
