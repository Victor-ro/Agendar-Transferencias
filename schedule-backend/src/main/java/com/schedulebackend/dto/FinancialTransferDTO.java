package com.schedulebackend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record FinancialTransferDTO(

        String originAccount,

        String destinationAccount,

        BigDecimal transferAmount,

        LocalDate transferDate,

        BigDecimal fee,

        LocalDateTime scheduledDate

) {
}
