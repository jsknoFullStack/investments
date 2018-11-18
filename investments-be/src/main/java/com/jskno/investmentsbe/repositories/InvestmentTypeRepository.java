package com.jskno.investmentsbe.repositories;

import com.jskno.investmentsbe.domain.InvestmentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentTypeRepository extends CrudRepository<InvestmentType, Long> {

    public InvestmentType findInvestmentTypeByDescription(String description);
}
