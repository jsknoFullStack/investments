package com.jskno.investmentsbe.domain;

import com.jskno.investmentsbe.domain.base.AbstractEntity;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
public class InvestmentTransaction extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investement_type_id")
    @NotNull(message = "The investment type is required")
    private InvestmentType investmentType;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    @NotNull(message = "The transaction type is required")
    private TransactionType transactionType;

    @Positive(message = "The price must be positive")
    private Double price;

    @Positive(message = "The investment units must be positive")
    private Double shares;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "The transaction date is required")
    @PastOrPresent(message = "None transaction can take place in the future")
    private Date transactionDate;

    public InvestmentTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InvestmentType getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(InvestmentType investmentType) {
        this.investmentType = investmentType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getShares() {
        return shares;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
