package com.capgemini.PecuniaFinancialManagement.Service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;



public interface IPassbookService {

	public List<TransactionEntity> displaypassbookByAccountnumber(long accountNumber) throws ResourceNotFoundException;
	public List<TransactionEntity>displaypassbookByDate(long accountNumber,LocalDate startDate,LocalDate endDate) throws ResourceNotFoundException;
	public List<TransactionEntity>updatePassbook(long accountNumber) throws ResourceNotFoundException;

}
