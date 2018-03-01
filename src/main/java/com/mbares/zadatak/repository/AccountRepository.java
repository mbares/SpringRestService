package com.mbares.zadatak.repository;

import com.mbares.zadatak.entity.Account;
import com.mbares.zadatak.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>{

    public Account findAccountByUserAndAccountNumber(User user, String accountNumber);

    public Account findAccountByAccountNumber(String accountNumber);
}
