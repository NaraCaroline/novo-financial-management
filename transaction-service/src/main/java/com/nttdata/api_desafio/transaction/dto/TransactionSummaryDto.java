package com.nttdata.api_desafio.transaction.dto;

import com.nttdata.api_desafio.transaction.domain.Transaction;
import com.nttdata.api_desafio.transaction.enums.TransactionStatus;

import java.math.BigDecimal;

public record TransactionSummaryDto(
        Long id,
        String description,
        BigDecimal amount,
        TransactionStatus status,
        String category,
        String username
) {
    public TransactionSummaryDto(Transaction transaction) {
        this(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getStatus(),
                transaction.getCategory(),
                transaction.getUsername()
        );
    }
}
