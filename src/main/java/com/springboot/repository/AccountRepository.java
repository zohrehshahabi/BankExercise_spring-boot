package com.springboot.repository;

import com.springboot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {


   ///Optional<Accoun> findByAccountNumber(String accountNumber );
}
