package com.capgemini.PecuniaFinancialManagement.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.PecuniaFinancialManagement.Entity.CustomerEntity;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{

     @Query(value= "select c from CustomerEntity c where accountNumber=:accNo")
	CustomerEntity findByAccount(@Param("accNo") Long accountNumber);

// 	@Query(value= "select c from C c where employeeContact=:contact")
// 	CustomerEntity findByContact(@Param("contact") Long accountNumber);

}
