package com.nttdata.api_desafio.user.dto;

import com.nttdata.api_desafio.user.domain.User;

public record UserSummaryDto(
        Long id,
        String username
) {
    public UserSummaryDto(User user) {
        this(user.getId(), user.getUsername());
    }
}
