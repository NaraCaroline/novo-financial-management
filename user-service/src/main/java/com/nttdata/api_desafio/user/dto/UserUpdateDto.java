package com.nttdata.api_desafio.user.dto;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDto(
        @NotNull
        String username,
        String password
) {
}
