package com.capgemini.PecuniaFinancialManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.AccountRepository;
import com.capgemini.PecuniaFinancialManagement.Repository.CustomerRepository;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Component
public class CustomerDAOImpl  implements ICustomerDAO{

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;
	@Override
	public String saveCustomer(CustomerEntity customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
		return "Customer added successfully";
	
	}

	
	
	@Override
	public String deleteCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		
		customerRepository.deleteById(customerId);
		return "Customer deleted succesfully";
	}


	
	@Override
	public CustomerEntity findCustomerById(Long contact) throws ResourceNotFoundException
	{
		CustomerEntity customer=customerRepository.findById(contact)
		.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + contact));
        return customer;

	}
	
	




	@Override
	public CustomerEntity findCustomerByAccount(Long accountNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		CustomerEntity accountCheck= customerRepository.findByAccount(accountNumber);
		
        return accountCheck;
	
	}



	@Override
	public void saveCustomerAccount(AccountEntity newAccount) {
		// TODO Auto-generated method stub
		accountRepository.save(newAccount);
	}

}
