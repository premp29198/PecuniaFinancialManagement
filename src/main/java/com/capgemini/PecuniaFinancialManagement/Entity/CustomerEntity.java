package com.capgemini.PecuniaFinancialManagement.Entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerdetails")
public class CustomerEntity {

	@Column (name="name")
	String name;
	
	@Id
	@Column (name="contact")
	Long contact;
	
	@Column (name="DOB")
	LocalDate DOB;
	
	@Column (name="gender")
	String gender;
	
	@Column (name="address")
	String address;
	
	@Column (name="city")
	String city;
	
	@Column (name="state")
	String state;
	
	@Column (name="pincode")
	int pincode;
	
	@Column (name="pan")
	String pan;
	
	@Column (name="adhaar")
	Long adhaar;
	
	@Column (name="accountNumber")
	Long accountNumber;

	
	public CustomerEntity() {}
	
	public CustomerEntity(String name, Long contact, String address, String city, String state,LocalDate DOB, String gender, 
			int pincode, String pan, Long adhaar, Long accountNumber) {
		this.name=name;
		this.contact=contact;
		this.address=address;
		this.city = city;
		this.state=state;
		this.DOB=DOB;
		this.gender=gender;
		this.pincode=pincode;
		this.pan=pan;
		this.adhaar=adhaar;
		this.accountNumber=accountNumber;
		
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Long getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(Long adhaar) {
		this.adhaar = adhaar;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
