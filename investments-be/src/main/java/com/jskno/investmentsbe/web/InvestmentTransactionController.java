package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.InvestmentTransaction;
import com.jskno.investmentsbe.servicies.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/investmenttransaction")
@Validated
public class InvestmentTransactionController {

    @Autowired
    private InvestmentTransactionService investmentTransactionService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public InvestmentTransaction createNewInvestmentTransaction(@Valid @RequestBody InvestmentTransaction investmentTransaction) {
        return investmentTransactionService.saveOrUpdateInvestmentTransaction(investmentTransaction);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvestmentTransaction getTransactionById(
            @Positive(message = "transactionId->The Id must be a positive number")
            @PathVariable Long id) {
        return investmentTransactionService.getInvestmentTransactionById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransactionById(
            @Positive(message = "transactionId->The Id must be a positive number")
            @PathVariable Long id) {
        investmentTransactionService.deleteTransactionById(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<InvestmentTransaction> getAllInvestmentTransactions() {
        return investmentTransactionService.getAllInvestmentTransaction();
    }
}
