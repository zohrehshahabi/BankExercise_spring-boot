package com.springboot.repository;

import org.hibernate.Transaction;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import java.util.List;

public interface TransactionRepository extends JpaAttributeConverter<Transaction,Long> {
    List<Transaction> findBySourceAccountIdOrderByInitiationDate(long id);
}

