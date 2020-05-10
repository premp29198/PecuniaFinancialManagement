package com.capgemini.PecuniaFinancialManagement.Controller;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.PecuniaFinancialManagement.Entity.CashTransaction;
import com.capgemini.PecuniaFinancialManagement.Entity.ChequeEntity;
import com.capgemini.PecuniaFinancialManagement.Repository.ChequeRepository;
import com.capgemini.PecuniaFinancialManagement.Service.ICreditService;
import com.capgemini.PecuniaFinancialManagement.exception.ResourceNotFoundException;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/credit")                                            
public class CreditController {

	@Autowired
	ICreditService creditService;
	static ArrayList<CashTransaction> products = new ArrayList<CashTransaction>();
	
	@Autowired
	ChequeRepository chequeRepository;
	
	@PostMapping("/cheque")
	 public String saveChequeTransaction(@RequestBody ChequeEntity cheque) throws NumberFormatException,ResourceNotFoundException
	 {
		
//		LocalDate systemDate = LocalDate.now();
//		Long benificaAccount=new Long("3505014102332");
//		Long payeeAccount = new Long("523641223456");
////		ChequeDetails chequeDetails = new ChequeDetails();
////		chequeDetails.setChequeNumber(123445);
////		chequeDetails.setBankName("SBI");
////		chequeDetails.setIfsc("SBIN0016993");
////		chequeDetails.setChequeDate(systemDate);
////		chequeDetails.setBenificiaryAccount(benificaAccount);
////		chequeDetails.setPayeeAccount(payeeAccount);
////		chequeDetails.setPayeeName("Prem Prakash");
////		chequeDetails.setAmount(5000);
////		
////	 creditService.saveChequeDetails(chequeDetails);
		// creditService.saveChequeDetails(new ChequeDetails(125425,500,"SBI","SBIN0016993",systemDate,benificaAccount,payeeAccount,"Gyan Prakash"));
	 
		
		System.out.println("=========================================================================================================="+cheque.getBankName());
//		chequeRepository.save(cheque);
		creditService.saveChequeDetails(cheque);
		return "Transaction Succesfull";
	 
	 }


	
	@PostMapping("/cash")
	public String saveCashTransaction(@RequestBody CashTransaction cash) throws NumberFormatException, ResourceNotFoundException{
	
//		//String accountNumber = Long.parseLong("523641223456");
//		//double amount = 20000;
//		Long accountNumber = Long.parseLong(request.getParameter("accountNumber")); 
//		double amount = Double.parseDouble("amount");
//		CashTransaction cash = new CashTransaction();
//		cash.setAccountNumber(accountNumber);
//		cash.setAmount(amount);
//		products.add(cash);
		creditService.saveCashTransaction(cash);
	
		System.out.println("Hii");
	return "Transaction succesfull";
	}
	
}
