package com.capgemini.PecuniaFinancialManagement.Repository;



import org.springframework.data.repository.CrudRepository;

import com.capgemini.PecuniaFinancialManagement.Entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

}
