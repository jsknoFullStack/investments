package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.TransactionType;
import com.jskno.investmentsbe.servicies.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/api/transactiontype")
@Validated
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @PostMapping("")
    public TransactionType createNewTransactionType(@Valid @RequestBody TransactionType transactionType) {
        return transactionTypeService.saveOrUpdateTransactionType(transactionType);
    }

    @GetMapping("/{description}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionType getTransactionTypeByDescription(
            @Size(message = "transactionTypeDescription->Description type must be between 4 and 8 characters")
            @PathVariable String description) {
        return transactionTypeService.getTransactionTypeByDescription(description);
    }

    @PostMapping("/{description}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransactionTypeByDescription(
            @Size(message = "transactionTypeDescription->Description type must be between 4 and 8 characters")
            @PathVariable String description) {
        transactionTypeService.deleteTransactionTypeByDescription(description);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<TransactionType> getAll() {
        return transactionTypeService.findAll();
    }

}
