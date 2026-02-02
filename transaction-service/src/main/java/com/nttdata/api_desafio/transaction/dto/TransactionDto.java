package com.nttdata.api_desafio.transaction.dto;

import com.nttdata.api_desafio.transaction.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDto(
        @NotBlank
        String description,
        @NotNull
        BigDecimal amount,
        @NotNull
        TransactionType type,
        @NotBlank
        String category) {}
