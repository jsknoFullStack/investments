package com.jskno.investmentsbe.servicies;

import com.jskno.investmentsbe.domain.TransactionType;
import com.jskno.investmentsbe.exceptions.EntityConstraintViolationException;
import com.jskno.investmentsbe.exceptions.EntityNotFoundException;
import com.jskno.investmentsbe.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionType saveOrUpdateTransactionType(TransactionType transactionType) {
        try {
        transactionType.setDescription(transactionType.getDescription().toUpperCase());
        return transactionTypeRepository.save(transactionType);
        } catch (DataIntegrityViolationException ex) {
                throw new EntityConstraintViolationException("uniqueTransactionTypeDescription",
                        new StringBuilder().append("The transaction type with description '")
                                .append(transactionType.getDescription())
                                .append("' already exists.").toString());
        }
    }

    public TransactionType getTransactionTypeByDescription(String description) {
        return transactionTypeRepository.findTransactionTypeByDescription(description.toUpperCase());
    }

    public void deleteTransactionTypeByDescription(String description) {
        TransactionType transactionType = transactionTypeRepository.findTransactionTypeByDescription(description.toUpperCase());
        if(transactionType == null) {
            throw new EntityNotFoundException(
                    "transactionType",
                    new StringBuilder()
                    .append("Transacition type could not be deleted. Transaction type with description '")
                    .append(description)
                    .append("' does not exist")
                    .toString());
        }
        transactionTypeRepository.delete(transactionType);
    }

    public Iterable<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }
}
