package com.nttdata.api_desafio.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
