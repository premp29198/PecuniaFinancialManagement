package com.capgemini.PecuniaFinancialManagement.Controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.ChequeRepository;
import com.capgemini.PecuniaFinancialManagement.Service.IDebitService;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/debit")                                            
public class DebitController {
	@Autowired
	ChequeRepository chequeRepository;
	@Autowired
	IDebitService debitService;

	@PostMapping("/cheque")
	 public String saveChequeTransaction(@RequestBody ChequeEntity cheque) throws NumberFormatException,ResourceNotFoundException
	 {
//		LocalDate systemDate = LocalDate.now();
//		
//		Long payeeAccount=new Long("523641223456");
//		Long benificaAccount = new Long("3505014102332");
//		ChequeDetails chequeDetails = new ChequeDetails();
//		chequeDetails.setChequeNumber(123456);
//		chequeDetails.setBankName("SBI");
//		chequeDetails.setIfsc("SBIN0016993");
//		chequeDetails.setChequeDate(systemDate);
//		chequeDetails.setBenificiaryAccount(benificaAccount);
//		chequeDetails.setPayeeAccount(payeeAccount);
//		chequeDetails.setPayeeName("Shashank Karn");
//		chequeDetails.setAmount(500);
//		
// debitService.saveChequeDetails(chequeDetails);
//		 debitService.saveChequeDetails(new ChequeDetails(125425,35000,"SBI","SBIN0016993",systemDate,benificaAccount,payeeAccount,"Gyan Prakash"));
	System.out.println("-------------------------------------------debit"+cheque.getIfsc());
		chequeRepository.save(cheque);
		return "Transaction Succesfull";
	 }
	@RequestMapping("/cash")
	public String saveCashTransaction(@RequestBody CashTransaction cash) throws NumberFormatException, ResourceNotFoundException{
	
//		Long accountNumber = Long.parseLong("523641223456");
//		double amount = 1000;
		debitService.saveCashTransaction(cash);
		 return "Transaction Succesfull";
	}






}
