package com.capgemini.PecuniaFinancialManagement.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;
import com.capgemini.PecuniaFinancialManagement.Service.IPassbookService;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;


@RestController
@RequestMapping(value = "/passbookdetails")
public class PassbookController {
	@Autowired
	IPassbookService passbookService;


	@GetMapping("/updatePassbook/{accountNumber}")
	public List<TransactionEntity>updatePassbook(@PathVariable long accountNumber) throws ResourceNotFoundException {
		return passbookService.updatePassbook(accountNumber);
	}

	@GetMapping("/dpban/{accountNumber}")
	public List<TransactionEntity> displaypassbookByAccountnumber(@PathVariable long accountNumber) throws ResourceNotFoundException
	{
		return passbookService.displaypassbookByAccountnumber(accountNumber);
	}
	@GetMapping(path="/{accountNumber}/startDate/{startDate}/endDate/{endDate}")
	public List<TransactionEntity>displaypassbookByDate(@PathVariable long accountNumber,@PathVariable String startDate,@PathVariable String endDate) throws ResourceNotFoundException
	{LocalDate s=LocalDate.parse(startDate);
		LocalDate e=LocalDate.parse(endDate);
	
		return passbookService.displaypassbookByDate(accountNumber,s,e);
	}
}