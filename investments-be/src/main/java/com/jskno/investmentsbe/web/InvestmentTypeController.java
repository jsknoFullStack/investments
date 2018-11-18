package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.InvestmentType;
import com.jskno.investmentsbe.servicies.InvestmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/investmenttype")
@Validated
public class InvestmentTypeController {

    @Autowired
    private InvestmentTypeService investmentTypeService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public InvestmentType createNewInvestmentType(@Valid @RequestBody InvestmentType investmentType) {
        return investmentTypeService.saveOrUpdateInvestmentType(investmentType);
    }

    @GetMapping("/{description}")
    @ResponseStatus(HttpStatus.OK)
    public InvestmentType getInvestmentTypeByDescription(
            @Size(min = 2, max = 10, message = "investmentTypeDescription->Description must be between 2 and 10 characters")
            @PathVariable String description) {

        return investmentTypeService.getTransactionTypeByDescription(description);
    }

    @DeleteMapping("/{description}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInvestmentTypeByDescription(
            @NotNull(message = "investmentTypeDescription->Description is required")
            @PathVariable String description) {

        investmentTypeService.deleteTransactionTypeByDescription(description);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<InvestmentType> getAll() {
        return investmentTypeService.findAll();
    }
}
