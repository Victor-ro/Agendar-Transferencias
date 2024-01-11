package com.schedulebackend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinancialTransferDTO(

        String originAccount,

        String destinationAccount,

        BigDecimal transferAmount,

        LocalDateTime transferDate,

        BigDecimal fee,

        LocalDateTime scheduledDate

) {
}
