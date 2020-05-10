package com.capgemini.PecuniaFinancialManagement.Dao;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface ICustomerDAO {

	public String saveCustomer(CustomerEntity customer);
	
	public String deleteCustomerById(Long customerId);
	
	public CustomerEntity findCustomerByAccount(Long accountNumber) throws ResourceNotFoundException;
	
	public CustomerEntity findCustomerById(Long contact) throws ResourceNotFoundException;

	public void saveCustomerAccount(AccountEntity newAccount);
}
