package com.jskno.investmentsbe.repositories;

import com.jskno.investmentsbe.domain.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {

    public TransactionType findTransactionTypeByDescription(String description);
}
