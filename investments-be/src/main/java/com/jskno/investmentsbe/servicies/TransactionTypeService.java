package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.TransactionType;
import com.jskno.investmentsbe.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionType saveOrUpdateTransactionType(TransactionType transactionType) {
        return transactionTypeRepository.save(transactionType);
    }
}
