package com.jskno.investmentsbe.web;

import com.jskno.investmentsbe.domain.InvestmentType;
import com.jskno.investmentsbe.servicies.InvestmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/investmenttype")
public class InvestmentTypeController {

    @Autowired
    private InvestmentTypeService investmentTypeService;

    @PostMapping("")
    public InvestmentType createNewInvestmentType(@RequestBody InvestmentType investmentType) {
        return investmentTypeService.saveOrUpdateInvestmentType(investmentType);
    }
}
