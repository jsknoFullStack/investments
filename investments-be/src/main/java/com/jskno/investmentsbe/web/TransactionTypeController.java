package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.TransactionType;
import com.jskno.investmentsbe.servicies.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactiontype")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping("")
    public TransactionType createNewTransactionType(@RequestBody TransactionType transactionType) {
        return transactionTypeService.saveOrUpdateTransactionType(transactionType);
    }

}
