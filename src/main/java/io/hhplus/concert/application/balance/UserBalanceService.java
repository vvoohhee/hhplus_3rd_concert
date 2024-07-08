package io.hhplus.concert.application.balance;

import io.hhplus.concert.presentation.balance.dto.FindBalanceDto;
import io.hhplus.concert.presentation.balance.dto.RechargeBalanceDto;

public interface UserBalanceService {
    FindBalanceDto.Response findUserBalance(Long userId);
    RechargeBalanceDto.Response recharge(Long userId, Integer amount);
}