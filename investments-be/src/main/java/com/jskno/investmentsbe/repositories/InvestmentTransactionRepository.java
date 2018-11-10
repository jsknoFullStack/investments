package com.jskno.investmentsbe.repositories;

import com.jskno.investmentsbe.domain.InvestmentTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentTransactionRepository extends CrudRepository<InvestmentTransaction, Long> {
}
