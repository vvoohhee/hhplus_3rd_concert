package io.hhplus.concert.presentation.balance.dto;

import io.hhplus.concert.domain.balance.Balance;
import io.hhplus.concert.domain.balance.command.FindBalanceResponseCommand;
import lombok.Builder;

import java.time.LocalDateTime;

public class FindBalanceDto {
    @Builder
    public record Response(
            int balance,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {}

    public static FindBalanceDto.Response of(FindBalanceResponseCommand command) {
        return FindBalanceDto.Response.builder()
                .balance(command.balance())
                .createdAt(command.createdAt())
                .updatedAt(command.updatedAt())
                .build();
    }
}