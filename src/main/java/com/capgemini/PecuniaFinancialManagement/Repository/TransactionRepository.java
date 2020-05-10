package com.capgemini.PecuniaFinancialManagement.Repository;

import java.time.LocalDate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.PecuniaFinancialManagement.Entity.TransactionEntity;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

	@Query(value=" select * from Transaction where accountNumber=?1 and status=0",nativeQuery=true)
	List<TransactionEntity>showpassbookByAccountnumber1(long accountNumber);
	@Modifying
		@Query(value="update Transaction t set t.status=1 where accountNumber=?1 and status=0",nativeQuery=true)
		void updatepassbookByAccountnumber1(@Param("accountNumber")long accountNumber);
	@Query(value="select * from Transaction where accountNumber=?1",nativeQuery=true)
	List<TransactionEntity>displaypassbookByAccountnumber1(long accountNumber);
	@Query(value="select * from Transaction where accountNumber=?1 and dateofTransaction between ?2 and ?3",nativeQuery=true)
	List<TransactionEntity>displaypassbookByDate1(Long accountNumber,LocalDate startDate,LocalDate endDate);
	 
//	List<Transaction> findByaccountNumber(Long accountNumber);

}
