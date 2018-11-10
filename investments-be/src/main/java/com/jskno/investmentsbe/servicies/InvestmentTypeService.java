package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.InvestmentType;
import com.jskno.investmentsbe.repositories.InvestmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestmentTypeService {

    @Autowired
    private InvestmentTypeRepository investmentTypeRepository;

    public InvestmentType saveOrUpdateInvestmentType(InvestmentType investmentType) {
        return investmentTypeRepository.save(investmentType);
    }
}
