package io.hhplus.concert.interfaces.presentation.balance;

import io.hhplus.concert.application.user.UserBalanceService;
import io.hhplus.concert.interfaces.presentation.balance.dto.FindBalanceDto;
import io.hhplus.concert.interfaces.presentation.balance.dto.RechargeBalanceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/balance")
@Tag(name = "Balance", description = "잔액 관련 API")
public class BalanceController {

    private final UserBalanceService userBalanceService;

    @GetMapping("/{userId}")
    @Operation(summary = "잔액 조회", description = "유저의 현재 잔액을 조회")
    public ResponseEntity<FindBalanceDto.Response> find(@PathVariable Long userId) {
        return ResponseEntity.ok(
                FindBalanceDto.Response.of(userBalanceService.findUserBalance(userId))
        );
    }

    @PutMapping("")
    @Operation(summary = "잔액 충전", description = "요청한 금액만큼 잔액을 충전")
    public ResponseEntity<RechargeBalanceDto.Response> recharge(
            @RequestBody RechargeBalanceDto.Request request) {
        return ResponseEntity.ok(
                RechargeBalanceDto.Response.of(userBalanceService.rechargeBalance(request.userId(), request.amount()))
        );
    }
}