package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.InvestmentType;
import com.jskno.investmentsbe.exceptions.EntityConstraintViolationException;
import com.jskno.investmentsbe.repositories.InvestmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentTypeService {

    @Autowired
    private InvestmentTypeRepository investmentTypeRepository;

    public InvestmentType saveOrUpdateInvestmentType(InvestmentType investmentType) {
        try {
            investmentType.setDescription(investmentType.getDescription().toUpperCase());
            return investmentTypeRepository.save(investmentType);
        } catch(DataIntegrityViolationException ex) {
            throw new EntityConstraintViolationException("uniqueInvestmentTypeDescription",
                    new StringBuilder().append("The investment type with description '")
                    .append(investmentType.getDescription())
                    .append("' already exists.").toString());
        }
    }

    public InvestmentType getTransactionTypeByDescription(String description) {
        return investmentTypeRepository.findInvestmentTypeByDescription(description.toUpperCase());
    }

    public void deleteTransactionTypeByDescription(String description) {
        InvestmentType investmentType = investmentTypeRepository.findInvestmentTypeByDescription(description.toUpperCase());
        investmentTypeRepository.delete(investmentType);
    }

    public Iterable<InvestmentType> findAll() {
        return investmentTypeRepository.findAll();
    }
}
