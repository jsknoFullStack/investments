package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.InvestmentTransaction;
import com.jskno.investmentsbe.repositories.InvestmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InvestmentTransactionService {

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    public Iterable<InvestmentTransaction> getAllInvestmentTransaction() {
        return investmentTransactionRepository.findAll();
    }

    public InvestmentTransaction saveOrUpdateInvestmentTransaction(@RequestBody InvestmentTransaction investmentTransaction) {
        return investmentTransactionRepository.save(investmentTransaction);
    }

}
