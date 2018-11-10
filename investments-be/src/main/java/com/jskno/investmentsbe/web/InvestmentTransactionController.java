package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.InvestmentTransaction;
import com.jskno.investmentsbe.servicies.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investmenttransaction")
public class InvestmentTransactionController {

    @Autowired
    private InvestmentTransactionService investmentTransactionService;

    @GetMapping("")
    public Iterable<InvestmentTransaction> getAllInvestmentTransactions() {
        return investmentTransactionService.getAllInvestmentTransaction();
    }

    @PostMapping("")
    public InvestmentTransaction createNewInvestmentTransaction(@RequestBody InvestmentTransaction investmentTransaction) {
        return investmentTransactionService.saveOrUpdateInvestmentTransaction(investmentTransaction);
    }
}
