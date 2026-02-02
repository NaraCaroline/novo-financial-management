package com.nttdata.api_desafio.transaction.domain;

import com.nttdata.api_desafio.transaction.dto.TransactionDto;
import com.nttdata.api_desafio.transaction.dto.TransactionUpdateDto;
import com.nttdata.api_desafio.transaction.enums.TransactionType;
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
    private TransactionType type;
    private String category;
    private String username;

    public Transaction() {}

    public Transaction(TransactionDto data, String username) {
        this.description = data.description();
        this.amount = data.amount();
        this.type = data.type();
        this.category = data.category();
        this.username = username;
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

    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }

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

    public void updateInfo(TransactionUpdateDto data) {
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.amount() != null) {
            this.amount = data.amount();
        }
        if (data.type() != null) {
            this.type = data.type();
        }
        if (data.category() != null) {
            this.category = data.category();
        }
    }
}
