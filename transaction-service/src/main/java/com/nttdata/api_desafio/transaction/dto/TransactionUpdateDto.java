package com.nttdata.api_desafio.transaction.dto;

import com.nttdata.api_desafio.transaction.enums.TransactionType;
import java.math.BigDecimal;

public record TransactionUpdateDto(
        String description,
        BigDecimal amount,
        TransactionType type,
        String category
) {}
