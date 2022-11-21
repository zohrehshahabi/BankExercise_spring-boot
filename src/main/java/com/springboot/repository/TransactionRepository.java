package com.springboot.repository;

import com.springboot.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {

    List<Transaction> findBySourceAccountIdOrderByInitiationDate(long id);

}
