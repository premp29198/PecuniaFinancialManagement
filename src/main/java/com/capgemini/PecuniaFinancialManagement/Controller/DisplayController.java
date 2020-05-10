package com.capgemini.PecuniaFinancialManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.Service.IDisplayService;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;
//
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/display")
public class DisplayController{
	
	@Autowired
	IDisplayService displayService;
	
	
	@RequestMapping("/transaction")
	public List<TransactionEntity> getAllTransaction()
	{
		List<TransactionEntity> transactionList = displayService.getAllTransaction();
		return transactionList;
	}
	
	@RequestMapping("/customerList")
	public List<CustomerEntity> getAllCustomer()
	{
		List<CustomerEntity> customerList = displayService.getAllCustomer();
		return customerList;
	}
	
	@GetMapping("/accountList")
	public List<AccountEntity> getAllAccount()
	{
		List<AccountEntity> accountList = displayService.getAllAccount();
		return accountList;
	}

	@RequestMapping("/chequeList/{id}")
	public ResponseEntity<ChequeEntity> getChequeById(@PathVariable Integer id)
			throws ResourceNotFoundException{
		ResponseEntity<ChequeEntity> cheque = displayService.getChequeById(id);
				
		return cheque;
		
	}
	
	@RequestMapping("/chequeList")
	public List<ChequeEntity> getAllChequeDetails()
	{
		List<ChequeEntity> chequeDetails = displayService.getAllCheque();
		return chequeDetails;
	}
	

}
