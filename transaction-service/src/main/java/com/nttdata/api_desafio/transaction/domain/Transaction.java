package com.nttdata.api_desafio.transaction.domain;

import com.nttdata.api_desafio.transaction.enums.TransactionStatus;
import com.nttdata.api_desafio.transaction.dto.TransactionDto;
import com.nttdata.api_desafio.transaction.dto.TransactionUpdateDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "transactions")
@Entity(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private String category;
    private String username;

    public Transaction() {}

    public Transaction(TransactionDto data, String username) {
        this.description = data.description();
        this.amount = data.amount();
        this.category = data.category();
        this.username = username;
        this.status = TransactionStatus.PENDING;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;}

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public TransactionStatus getStatus() {return status;}
    public void setStatus(TransactionStatus status) {this.status = status;}

    public void updateInfo(TransactionUpdateDto data) {
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.amount() != null) {
            this.amount = data.amount();
        }
        if (data.status() != null) {
            this.status = data.status();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
    }
}
