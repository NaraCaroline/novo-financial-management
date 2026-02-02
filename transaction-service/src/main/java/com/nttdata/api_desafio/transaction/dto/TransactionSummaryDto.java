package com.nttdata.api_desafio.transaction.dto;

import com.nttdata.api_desafio.transaction.domain.Transaction;
import com.nttdata.api_desafio.transaction.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionSummaryDto(
        Long id,
        String description,
        BigDecimal amount,
        TransactionType type,
        String category,
        String username
) {
    public TransactionSummaryDto(Transaction transaction) {
        this(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getCategory(),
                transaction.getUsername()
        );
    }
}
