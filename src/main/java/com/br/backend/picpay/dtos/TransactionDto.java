package com.br.backend.picpay.dtos;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, Long payerId, Long payeeId ) {
}
