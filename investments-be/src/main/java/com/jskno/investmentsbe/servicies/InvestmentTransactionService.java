package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.InvestmentTransaction;
import com.jskno.investmentsbe.exceptions.EntityNotFoundException;
import com.jskno.investmentsbe.repositories.InvestmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class InvestmentTransactionService {

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    public InvestmentTransaction saveOrUpdateInvestmentTransaction(@RequestBody InvestmentTransaction investmentTransaction) {
        return investmentTransactionRepository.save(investmentTransaction);
    }

    public InvestmentTransaction getInvestmentTransactionById(Long id) {
        return investmentTransactionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        "investmentTransaction",
                        new StringBuilder()
                        .append("Transaction not found. Transaction with Id '")
                        .append(id)
                        .append("' does not exist.")
                        .toString()
                )
        );
    }

    public void deleteTransactionById(Long id) {
        Optional<InvestmentTransaction> transaction = investmentTransactionRepository.findById(id);
        if(!transaction.isPresent()) {
            throw new EntityNotFoundException(
                "investmentTransaction",
                new StringBuilder()
                        .append("Transaction not deleted. Transaction with Id '")
                        .append(id)
                        .append("' does not exist.")
                        .toString()
            );
        }
        investmentTransactionRepository.delete(transaction.get());
    }

    public Iterable<InvestmentTransaction> getAllInvestmentTransaction() {
        return investmentTransactionRepository.findAll();
    }


}
