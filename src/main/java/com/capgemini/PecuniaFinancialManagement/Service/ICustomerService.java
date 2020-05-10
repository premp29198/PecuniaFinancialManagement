package com.capgemini.PecuniaFinancialManagement.Service;

import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

public interface ICustomerService {

	public String saveCustomer(CustomerEntity customer) throws ResourceNotFoundException;
	
	public String deleteCustomerById(Long customerId);
	
	public String updateCustomerName(Long customerNumber, String customerNewName ) throws ResourceNotFoundException;
	
	public String updateCustomerAddress(Long customerNumber, String customerNewAddress ) throws ResourceNotFoundException;

	public 	String updateCustomerContact(Long customerOldNumber, Long customerNewNumber) throws ResourceNotFoundException;
}
