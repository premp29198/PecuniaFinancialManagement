package com.capgemini.PecuniaFinancialManagement.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.PecuniaFinancialManagement.Dao.ICustomerDAO;
import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;
import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDAO customerDao;
	@Override
	public String saveCustomer(CustomerEntity customer) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		
		
//		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/YYYY");
//				 LocalDate date = formatter.  
		
		Long accountNumber =Math.abs(generateRandom(12));
		CustomerEntity accountCheck= customerDao.findCustomerByAccount(accountNumber);
		if(accountCheck != null) {
		saveCustomer(customer);	
		
		}
		
		else
			{customer.setAccountNumber(accountNumber);
		customerDao.saveCustomer(customer);
			
			}
		CustomerEntity newCustomer=customerDao.findCustomerById(customer.getContact());
		AccountEntity newAccount = new AccountEntity(newCustomer.getAccountNumber(),newCustomer.getName(),5000);
		customerDao.saveCustomerAccount(newAccount);
		return "customer Added succesfully"; 	}

	
	public static long generateRandom(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	
	
	
	@Override
	public String deleteCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		
		customerDao.deleteCustomerById(customerId);
		
		return "Customer deleted succesfully";
	}
	@Override
	public String updateCustomerName(Long customerNumber,String customerNewName) throws ResourceNotFoundException
	{
		CustomerEntity customer=customerDao.findCustomerById(customerNumber);
		
			customerDao.deleteCustomerById(customerNumber);
		
		customer.setName(customerNewName);
		customerDao.saveCustomer(customer);
		return  "Customer Name Updated succesfully";
		
	}


	@Override
	public String updateCustomerAddress(Long customerNumber, String customerNewAddress) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		CustomerEntity customer=customerDao.findCustomerById(customerNumber);
		customerDao.deleteCustomerById(customerNumber);
		
		customer.setAddress(customerNewAddress);
		customerDao.saveCustomer(customer);
		return  "Customer Address Updated succesfully";
		}
	
	@Override
	public String updateCustomerContact(Long customerOldNumber,Long customerNewNumber) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		CustomerEntity customer=customerDao.findCustomerById(customerOldNumber);
			customerDao.deleteCustomerById(customerOldNumber);
		
		customer.setContact(customerNewNumber);
		customerDao.saveCustomer(customer);
		return  "Customer Address Updated succesfully";
	}
	

}
