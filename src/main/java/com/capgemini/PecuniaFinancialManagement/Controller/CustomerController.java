package com.capgemini.PecuniaFinancialManagement.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;
import com.capgemini.PecuniaFinancialManagement.Service.ICustomerService;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	@PostMapping("/save")
	public String saveCustomer(@RequestBody CustomerEntity customer) throws ResourceNotFoundException
	{
//		LocalDate dOB = LocalDate.of(1995, 11, 29);
//		CustomerEntity customer = new CustomerEntity();
//		customer.setName("Gyan Prakash");
//		customer.setContact(Long.parseLong("7355257324"));
//		customer.setAddress("178/C Patel Nagar");
//		customer.setCity("Kanpur");
//		customer.setState("Uttar Pradesh");
//		
//		customer.setDOB(dOB);
//		customer.setGender("Male");
//		customer.setPincode(208007);
//		customer.setPan("PANS995");
//		customer.setAdhaar(Long.parseLong("764760079207"));
//		
		
	String review=	customerService.saveCustomer(customer);
		
		return review;
	}
	
	
	@RequestMapping("/delete")
	public String deleteCustomer()
	{
	String review=	customerService.deleteCustomerById(Long.parseLong("8127976558"));
		return review;
	}
	
	
	@RequestMapping("/updateName")
	public String updateCustomerName() throws NumberFormatException, ResourceNotFoundException
	{
		String review =customerService.updateCustomerName(Long.parseLong("7777888999"), "Akash");
	return review;
	}
	
	@RequestMapping("/updateAddress")
	public String updateCustomerAddress() throws NumberFormatException, ResourceNotFoundException
	{
		String review =customerService.updateCustomerAddress(Long.parseLong("7355257324"), "Patel Nagar");
	return review;
	}
	
	@RequestMapping("/updateContact")
	public String updateCustomerContact() throws NumberFormatException, ResourceNotFoundException
	{
		String review =customerService.updateCustomerContact(Long.parseLong("7777888999"),Long.parseLong("7355257324"));
	return review;
	}
}
