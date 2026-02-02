package com.nttdata.api_desafio.transaction.dto;

import com.nttdata.api_desafio.transaction.enums.TransactionStatus;
import java.math.BigDecimal;

public record TransactionUpdateDto(
        String description,
        BigDecimal amount,
        TransactionStatus status,
        String category
) {}
